package concurrent.imooc;

/**
 * @author shuai
 * sychronized深度解析
 */

/**
 * 创建线程的三种方式的对比
 * 1. 采用实现 Runnable、Callable 接口的方式创建多线程时，线程类只是实现了 Runnable 接口或 Callable 接口，还可以继承其他类。
 * 2. 使用继承 Thread 类的方式创建多线程时，编写简单，如果需要访问当前线程，则无需使用 Thread.currentThread() 方法，直接使用 this 即可获得当前线程。
 */
public class DisappearRequest1 implements Runnable{
    static DisappearRequest1 instance = new DisappearRequest1();
    static int n = 0;
    Object lock1 = new Object();
    Object lock2 = new Object();
    //两个lock锁定的不同代码块可以并行执行

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
//        t1.join();
//        t2.join();
        //join -> Waits for this thread to die.
        while (t1.isAlive() || t2.isAlive());
        System.out.println(n);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            synchronized (lock1){
                n++;
            }
//            synchronized (this){
//                n++;
//            }
        }
    }
}
