package concurrent.multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1.继承Thread类，重写父类run()方法
 * 2.实现runnable接口
 * 3.使用ExecutorService、Callable、Future实现有返回结果的多线程(JDK5.0以后)
 * @see UseFuture
 * 应用程序可以使用Executor框架来创建线程池
 * Created by shuai on 2017/2/7.
 */
public class ThreeMethod {
    public static void main(String args[]){
       Thread2 t2 = new Thread2(1,10);
       Thread2 t21 = new Thread2(90,101);
//       t2.run(); //非线程调用
//       t21.run(); //非线程调用
       new Thread(t2).start();
       new Thread(t21).start();
       Thread t1 = new Thread1(200,210);
       t1.start();

       ExecutorService es = Executors.newCachedThreadPool();
       es.submit(new Thread3(998,1001));
       es.shutdown(); //关闭Executor
        
    }
}

class Thread1 extends Thread{
    private int a;
    private int b;
    public Thread1(int a,int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public void run(){
        for (int i = a; i < b; i++) {
            System.out.println(i+"...");
        }
    }
}

class Thread2 implements Runnable{
    private int x = 1;
    private int y = 1;
    public Thread2(int x,int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public void run() {
        for (int i = x; i < y; i++) {
            System.out.println(i+"!!!");
        }
    }
}

class Thread3 implements Callable<Integer>{
    // 返回类型不能是原始数据类型
    private int m;
    private int n;

    public Thread3(int m, int n) {
        this.m = m;
        this.n = n;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = m; i < n; i++) {
            System.out.println(i+"???");
        }
        return 0;
    }
}