package thinkinginjava.concurrency;

//: concurrency/ExplicitCriticalSection.java
// Using explicit Lock objects to create critical sections.
import java.util.concurrent.locks.*;

// Synchronize the entire method:
class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}

// Use a critical section:
class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }

    /**
     * lock与synchronized的内在机制？有何区别，如何区分是不是同一把锁？
     * 根据API的说明：“一个可重入的互斥锁定 Lock，它具有与使用 synchronized 方法和语句所访问的隐式监视器锁定相同的一些基本行为和语义，但功能更强大。”
     *
     * 继承this应该都是子类的this,理论上lock(this) == synchronized(this)，为何不是同一把锁？
     * @see core.ThisClass
     * <a href="https://agrael.iteye.com/blog/685840">不要同时使用ReentrantLock类与synchronized关键字锁定会修改同一个资源的不同方法</a>
     * 因为ReentrantLock与synchronized所提供的机制不同，导致了他们是相对独立的，相当于是两把锁，各自锁定各自的。
     *
     * 解决PairValuesNotEqualException
     * 重写getPair是其用的锁是跟increment用的锁是同一个锁
     * @return Pair
     */
    @Override
    public Pair getPair() {
        lock.lock();
        try{
            return new Pair(p.getX(), p.getY());
        }finally {
            lock.unlock();
        }
    }
//    public synchronized Pair getPair() {
//        // Make a copy to keep the original safe:
//        return new Pair(p.getX(), p.getY());
//    }

}

public class ExplicitCriticalSection {
    public static void main(String[] args) throws Exception {
        PairManager
                pman1 = new ExplicitPairManager1(),
                pman2 = new ExplicitPairManager2();
        CriticalSection.testApproaches(pman1, pman2);
    }
} /* Output: (Sample)
pm1: Pair: x: 15, y: 15 checkCounter = 174035
pm2: Pair: x: 16, y: 16 checkCounter = 2608588
*///:~

/*
Exception in thread "pool-1-thread-4" thinkinginjava.concurrency.Pair$PairValuesNotEqualException: Pair values not equal: x: 2, y: 1
	at thinkinginjava.concurrency.Pair.checkState(CriticalSection.java:36)
	at thinkinginjava.concurrency.PairChecker.run(CriticalSection.java:109)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
	at java.lang.Thread.run(Thread.java:748)
pm1: Pair: x: 255, y: 255 checkCounter = 2
pm2: Pair: x: 256, y: 256 checkCounter = 2158054
 */