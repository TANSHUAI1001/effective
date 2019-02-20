package effectivejava.chapter2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuai on 2017/2/8.
 */
public class TestOne {
    public static void main(String []args){
        Map<Integer,Integer> map = new HashMap<>();
        int s = map.getOrDefault(10,0);
//        SingletonElvis se = SingletonElvis.INSTANCE;
//        System.out.println(se.leave());
//        int []cc = new int[4];
//        cc[0].climb();
    }
}
