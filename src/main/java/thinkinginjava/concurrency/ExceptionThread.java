package thinkinginjava.concurrency;

//: concurrency/ExceptionThread.java
// {ThrowsException}
import com.sun.istack.internal.NotNull;

import java.util.concurrent.*;

class ExceptionThread2 implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}

class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}

public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }
    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new ExceptionThread());

//        try {
//            ExecutorService exec =
//                    Executors.newCachedThreadPool();
//            exec.execute(new ExceptionThread());
//        } catch(RuntimeException ue) {
//            // This statement will NOT execute!
//            System.out.println("Exception has been handled!");
//        }

//        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler()); // 静态设置从run抛出的异常的处理

        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
} ///:~