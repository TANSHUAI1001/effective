package leetcode;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by shuai on 2017/2/5.
 */
public class Test {
    public static void main(String args[]){
//        Map<Integer,Integer> map = new HashMap<>();
//        int sum = 0;
//        map.put(3,0);
//        map.put(0,4);
//        System.out.println(map.getOrDefault(sum,0));

        // collection.toArray()
        String result = "China,Guangdong,Guangzhou";
        char[]x = result.toCharArray();
        System.out.println(Arrays.toString(x));

        List<String> s = new LinkedList<>();
        s.add("China");
        s.add("Guangdong");
        s.add("Guangzhou");
        String[] r = s.toArray(new String[0]);
        System.out.println(Arrays.toString(r));
        Logger logger = Logger.getLogger("test");
        logger.log(Level.INFO,"什么情况");
        logger.info("没有其他的函数了");


    }
}
