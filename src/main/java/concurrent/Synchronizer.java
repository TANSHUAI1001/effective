package concurrent;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by shuai on 2018/4/3.
 * CyclicBarrier与CountDownLatch比较
 * 1）CountDownLatch:一个线程(或者多个)，等待另外N个线程完成某个事情之后才能执行；
 * CyclicBarrier:N个线程相互等待，任何一个线程完成之前，所有的线程都必须等待。
 *
 * 2）CountDownLatch:一次性的；CyclicBarrier:可以重复使用。
 *
 * 3）CountDownLatch基于AQS；CyclicBarrier基于锁和Condition。本质上都是依赖于volatile和CAS实现的。
 * CAS(Compare And Swap)，即比较并交换。
 * AQS(AbstractQueuedSynchronizer)
 * <a href="https://www.cnblogs.com/dream-to-pku/p/9186126.html">【多线程系列】AQS CAS简单介绍</a>
 */
class First implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private CountDownLatch countDownLatch;
    private static Random rand = new Random(47);
    First(CountDownLatch latch){
        this.countDownLatch = latch;
    }
    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            System.out.println(this+" completed");
            countDownLatch.countDown();
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "First "+id;
    }
}

class Second implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private CountDownLatch waitLatch;
    private CountDownLatch selfLatch;
    private static Random rand = new Random(47);
    Second(CountDownLatch waitLatch,CountDownLatch selfLatch){
        this.waitLatch = waitLatch;
        this.selfLatch = selfLatch;
    }
    @Override
    public void run() {
        try{
            waitLatch.await();
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            System.out.println(this+" completed");
            selfLatch.countDown();
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Second "+id;
    }
}

class Third implements Runnable{
    private static int count = 0;
    private final int id = count++;
    private CountDownLatch countDownLatch;
    private static Random rand = new Random(47);
    Third(CountDownLatch latch){
        this.countDownLatch = latch;
    }
    @Override
    public void run() {
        try{
            countDownLatch.await();
            TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
            System.out.println(this+" completed");
        }catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Third "+id;
    }
}
public class Synchronizer {
    static void testCountDownLatch(){
        CountDownLatch latch1 = new CountDownLatch(10);
        CountDownLatch latch2 = new CountDownLatch(20);
        ExecutorService exec = Executors.newCachedThreadPool();
        // Second等待First执行完再执行
        // Third等待Second执行完再执行
        for (int i = 0; i < 10; i++) {
            exec.execute(new First(latch1));
        }
        for (int i = 0; i < 20; i++) {
            exec.execute(new Second(latch1,latch2));
        }
        for (int i = 0; i < 5; i++) {
            exec.execute(new Third(latch2));
        }

        exec.shutdown();
    }
    static void testCyclicBarrier(){
        // 一组任务，多个步骤，在下一步之前，先等组内所有任务完成这个步骤
        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {

            }
        });
    }
    static void testSemaphore(){
        Semaphore semaphore = new Semaphore(10);
    }
    static void testExchanger(){
        Exchanger exchanger = new Exchanger();
    }

    /**
     * iterator() 永远返回空，因为里面没东西。
     * peek() 永远返回null。
     * put() 往queue放进去一个element以后就一直wait直到有其他thread进来把这个element取走。
     * offer() 往queue里放一个element后立即返回，如果碰巧这个element被另一个thread取走了，offer方法返回true，认为offer成功；否则返回false。
     * offer(2000, TimeUnit.SECONDS) 往queue里放一个element但是等待指定的时间后才返回，返回的逻辑和offer()方法一样。
     * take() 取出并且remove掉queue里的element（认为是在queue里的。。。），取不到东西他会一直等。
     * poll() 取出并且remove掉queue里的element（认为是在queue里的。。。），只有到碰巧另外一个线程正在往queue里offer数据或者put数据的时候，该方法才会取到东西。否则立即返回null。
     * poll(2000, TimeUnit.SECONDS) 等待指定的时间然后取出并且remove掉queue里的element,其实就是再等其他的thread来往里塞。
     * isEmpty()永远是true。
     * remainingCapacity() 永远是0。
     * remove()和removeAll() 永远是false。
     */
    static void testSynchronousQueue(){
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        takeThread.start();
    }/*put thread start
    take thread start
    take from putThread: 1
    take thread end
    put thread end *///:~

    public static void main(String[] args) {

//        testCountDownLatch();
//        testCyclicBarrier();
//        testSemaphore();
//        testExchanger();
        testSynchronousQueue();
    }
}
