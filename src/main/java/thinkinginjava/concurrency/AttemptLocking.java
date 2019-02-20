package thinkinginjava.concurrency;

//: concurrency/AttemptLocking.java
// Locks in the concurrent library allow you
// to give up on trying to acquire a lock.
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();
    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch(InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " +
                    captured);
        } finally {
            if(captured)
                lock.unlock();
        }
    }
    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed(); // (1)True -- lock is available
        al.timed();   // (2)True -- lock is available
        // Now create a separate task to grab the lock:
        new Thread() {
            { setDaemon(true); }
            public void run() {
                al.lock.lock();
                System.out.println("acquired");
            }
        }.start();
//        Thread.yield(); // Give the 2nd task a chance
        // yield 是线程让步，调度器重新调度
        try {
            TimeUnit.MILLISECONDS.sleep(1);
            // https://blog.csdn.net/wangbingfengf98/article/details/75253751
            // TimeUnit sleep 是调用 Thread.sleep(long millis, int nanos)
            // 暂停线程时它不会释放锁
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        al.untimed(); // False -- lock grabbed by task
        al.timed();   // False -- lock grabbed by task
    }
} /* Output:
tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
acquired
tryLock(): false
tryLock(2, TimeUnit.SECONDS): false
*///:~结果不一致

/* Output:
tryLock(): true
acquired
tryLock(2, TimeUnit.SECONDS): false
*///:~when (1)(2) are commented

/* Output:
tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
tryLock(): true
tryLock(2, TimeUnit.SECONDS): true
acquired
*///:~when (1)(2) are not commented