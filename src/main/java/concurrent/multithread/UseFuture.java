package concurrent.multithread;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by shuai on 2017/3/8.
 */
public class UseFuture implements Callable<int []>{
    private int num;

    public UseFuture(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        ExecutorService fixed = Executors.newFixedThreadPool(2);
        Future<int []> future1 = fixed.submit(new UseFuture(4));
        Future<int []> future2 = fixed.submit(new UseFuture(6));
        fixed.shutdown();
        try {
            // MICROSECONDS 微秒，MILLISECONDS 毫秒
            System.out.println("#f1#"+Arrays.toString(future1.get(100,TimeUnit.MILLISECONDS)));
            System.out.println("#f2#"+Arrays.toString(future2.get(100,TimeUnit.MILLISECONDS)));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public int[] call() throws Exception {
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = new Random().nextInt();
            Thread.yield();
        }
        return array;
    }
}
