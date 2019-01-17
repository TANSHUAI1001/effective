package thinkinginjava.concurrency;

/**
 * 在字节码层面上，race++不止一行代码，所有不是原子操作
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase(){
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }
        // System.out.println(Thread.activeCount()); // 2，IDEA可能有个守护进程Monitor Ctrl-Break
        // java.lang.ThreadGroup[name=main,maxpri=10]
        // Thread[main,5,main]
        // Thread[Monitor Ctrl-Break,5,main]
        while (Thread.activeCount() > 2){
            Thread.currentThread().getThreadGroup().list();
            Thread.yield();
        }
        System.out.println(race);
    }
}
