package thinkinginjava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        while (countDown-- > 0){
            System.out.println(status());
            try {
                // old style
//                Thread.sleep(100);
                // new style java SE5/6
                TimeUnit.MILLISECONDS.sleep(100);

            } catch (InterruptedException e) { //不能跨线程传回main()
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
