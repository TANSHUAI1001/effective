package chapter2;

/**
 * Created by shuai on 2017/2/8.
 */
public class TestOne {
    public static void main(String []args){
        SingletonElvis se = SingletonElvis.INSTANCE;
        System.out.println(se.leave());
        int []cc = new int[4];
//        cc[0].climb();
    }
}
