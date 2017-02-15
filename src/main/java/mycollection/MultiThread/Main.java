package mycollection.MultiThread;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created by shuai on 2017/1/22.
 */
public class Main {
    public static void main(String args[]){
            TransferQueue<String> queue = new LinkedTransferQueue<String>();
            Thread producer = new Thread(new Producer(queue));
            producer.setDaemon(true); //设置为守护进程使得线程执行结束后程序自动结束运行
            producer.start();
            for (int i = 0; i < 10; i++) {
//                System.out.println("getting...");
                Thread consumer = new Thread(new Consumer(queue));
                consumer.setDaemon(true);
                consumer.start();
//                System.out.println("when consumer stated : "+Thread.currentThread().getName()
//                +" consumer : "+consumer.getName());
//                System.out.println("waiting status : "+queue.hasWaitingConsumer());
                try {
//                    System.out.println("sleeping...");
                    // 消费者进程休眠一秒钟，以便以便生产者获得CPU，从而生产产品
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //程序可能由于退出而看不到最后一个输出。
//            Timer timer = new Timer();
//            //  第一次试探timer的使用
//            timer.schedule(new TimerTask(){
//
//                @Override
//                public void run() {
//                    System.out.println("bombing...");
//                }
//            },1000,2000);
        }

}
