package concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

/**
 * Created by shuai on 2018/4/3.
 */
public class Synchronizer {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(10);
        CyclicBarrier barrier = new CyclicBarrier(10);
        Semaphore semaphore = new Semaphore(10);
        Exchanger exchanger = new Exchanger();
    }
}
