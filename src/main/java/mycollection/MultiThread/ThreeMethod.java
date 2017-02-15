package mycollection.MultiThread;

/**
 * Created by shuai on 2017/2/7.
 */
public class ThreeMethod {
    public static void main(String args[]){
        //1.继承Thread类，重写父类run()方法
        //2.实现runnable接口
        //3.使用ExecutorService、Callable、Future实现有返回结果的多线程(JDK5.0以后)
    }

    public class thread1 extends Thread{

    }

    public class thread2 implements Runnable{

        @Override
        public void run() {

        }
    }

    public class thread3 {

    }
}
