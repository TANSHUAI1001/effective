package chapter8;

/**
 * Created by shuai on 2017/2/13.
 */
import java.util.Random;
import java.lang.*;
import java.io.*;
public class UseLib {
    public static void main(String []args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs(Integer.MIN_VALUE)%3);
        fun();
        System.out.println();
    }
    public static void fun(){
        Random random = new Random();

        int low = 0;
        for (int i = 0; i < 10000; i++) {
            int x = random.nextInt(10);
            if(x < 5){
                low++;
            }
        }
        System.out.println(low);
    }
}
