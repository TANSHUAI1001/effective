package chapter8;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by shuai on 2017/2/8.
 */
public class ReflectOfMine {
    public static void main(String []args){
        Class<?> cl = null;
        try {
            cl = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            System.out.println("class not found.");
            e.printStackTrace();
        }

        Set<String> s = null;
        try {
            s = (Set<String>) cl.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        s.addAll(Arrays.asList(args).subList(1,args.length));
        System.out.println(s);
    }
}
