package thinkinginjava.concurrency;

//: concurrency/SimplePriorities.java
// Shows the use of thread priorities.
import java.util.concurrent.*;

public class SimplePriorities implements Runnable {
    private int countDown = 5;
    private volatile double d; // No optimization
    private int priority;
    public SimplePriorities(int priority) {
        this.priority = priority;
    }
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true) {
            // An expensive, interruptible operation:
            for(int i = 1; i < 10000000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 100000 == 0)
                    Thread.yield();
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        // 最低优先级1，默认5，最高10，优先级低并不是得不到执行而是频率较低（不会导致死锁）
        // 不同操作系统的优先级与JDK10个优先级映射不是很好，可移植的只有MIN，NORM，MAX
        for(int i = 0; i < 5; i++) exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));

        for(int i = 0; i < 5; i++) exec.execute(new SimplePriorities(Thread.NORM_PRIORITY));

        for(int i = 0; i < 5; i++)exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));

        exec.shutdown();
    }
}