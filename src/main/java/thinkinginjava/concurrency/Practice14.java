package thinkinginjava.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Practice14 {
    private static AtomicInteger n = new AtomicInteger(10);
    public void generator(){
        for (int i = 0; i < n.get(); i++) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("time out at "+System.currentTimeMillis());
                    n.addAndGet(-1);
                    if(n.get() == 0) System.exit(0);
                }
            },1000);
        }
    }
    public static void main(String[] args) {
        n = new AtomicInteger(10);
        new Practice14().generator();
    }
}
