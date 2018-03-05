package mycollection.MultiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shuai on 2017/2/7.
 */
public class ThreeMethod {
    public static void main(String args[]){
        //1.继承Thread类，重写父类run()方法
        //2.实现runnable接口
        //3.使用ExecutorService、Callable、Future实现有返回结果的多线程(JDK5.0以后)
        //  应用程序可以使用Executor框架来创建线程池

       ThreeMethod threeMethod = new ThreeMethod();
       Thread2 t2 = threeMethod.new Thread2(1,10);
       Thread2 t21 = threeMethod.new Thread2(90,101);
//       t2.run();
//       t21.run();
       new Thread(t2).start();
       new Thread(t21).start();
       Thread t1 = threeMethod.new Thread1(200,210);
       t1.start();
       Thread3 t3 = threeMethod.new Thread3(998,1001);
        ExecutorService es = Executors.newCachedThreadPool();
        es.submit(t3);
        
    }

    public class Thread1 extends Thread{
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

    public class Thread2 implements Runnable{
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

    public class Thread3 implements Callable{
        private int m;
        private int n;

        public Thread3(int m, int n) {
            this.m = m;
            this.n = n;
        }

        @Override
        public Object call() throws Exception {
            for (int i = m; i < n; i++) {
                System.out.println(i+"???");
            }
            return null;
        }
    }
}
