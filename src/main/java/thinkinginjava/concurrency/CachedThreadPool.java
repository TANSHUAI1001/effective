package thinkinginjava.concurrency;

import java.util.concurrent.*;

/**
 *
 * CachedThreadPool 是首选，执行过程中通常会创建与所需数量相同的线程，在回收线程时停止创建。
 * FixedThreadPool
 * SingleThreadExecutor 是 FixedThreadPool(1)
 * 在任何线程池中，现有的线程在可能的情况下，都会被自动复用
 */
public class CachedThreadPool {
     static void cacheThreadPool(){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
//            exec.execute(new LiftOff());
            Future future = exec.submit(new LiftOff()); // 返回值Future
            try {
                Object object1 = future.get(); // Waits if necessary for the computation to complete, and then retrieves its result.
//                Object object2 = future.get(1, TimeUnit.MICROSECONDS);
                // Waits if necessary for at most the given time for the computation to complete, and then retrieves its result, if available.
                System.out.println(object1); // runnable 无返回值，null
            } catch (
                    Exception
//                    InterruptedException
//                    | ExecutionException
//                    | TimeoutException
                    e) {
                System.out.println(e.getMessage());
//                e.printStackTrace();
            }
            future.isDone(); //执行是完成
            future.cancel(false); // 可以执行cancel方法，取消执行；
            System.out.println(future.isCancelled()); //是否取消
        }
        exec.shutdown();
    }

    static void fixedThreadPool(){
        ExecutorService fixed = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 6; i++) {
            fixed.execute(new LiftOff());
        }
        fixed.shutdown();
        System.out.println(fixed.isShutdown());
    }

    static void singleThreadExecutor(){
        ExecutorService single = Executors.newSingleThreadExecutor();
        single.execute(new LiftOff());
        single.execute(new LiftOff());
        single.shutdown();
    }
    public static void main(String[] args) {
        cacheThreadPool();
//        fixedThreadPool();
//        singleThreadExecutor(); //相当于单线程，串行执行

    }
}
