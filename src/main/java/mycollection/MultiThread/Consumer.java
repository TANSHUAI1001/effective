package mycollection.MultiThread;

import java.util.concurrent.TransferQueue;

/**
 * Created by shuai on 2017/1/22.
 */
public class Consumer implements Runnable{
    private final TransferQueue<String> queue;

    public Consumer(TransferQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println(" Consumer " + Thread.currentThread().getName()
                    + queue.take());

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
