package mycollection.MultiThread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Created by shuai on 2017/3/8.
 */
public class UseFuture implements Callable{
    private int start;
    private int end;
    private int num;

    public UseFuture(int start, int end,int num) {
        this.start = start;
        this.end = end;
        this.num = num;
    }

    public static void main(String[] args) {
        Callable<String []> f1 = new UseFuture(0,0,10);
        Callable<String []>  f2 = new UseFuture(0,0,20);
        FutureTask future1 =  new FutureTask(f1);
        FutureTask future2 =  new FutureTask(f2);
        new Thread(future1).start();
        new Thread(future2).start();


        try {
            System.out.println(future1.get());
            System.out.println(future2.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    public String func(String s){
        StringBuilder ss = new StringBuilder(s);
        ss.append("s");
        return ss.toString();
    }

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10)+num;
    }
}
