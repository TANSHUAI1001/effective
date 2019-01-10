package effectivejava.chapter8;

import java.util.Arrays;
import java.util.Set;

/**
 * Created by shuai on 2017/2/8.
 */
public class ReflectOfMine {

    @SuppressWarnings("unchecked")
    public static void main(String []args){
        // java.util.HashSet 11 22 33
        Class<?> cl = null;
        Set<String> s = null;
        try {
            cl = Class.forName(args[0]);
            s = (Set<String>) cl.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFound");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.println("IllegalAccess");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.out.println("Instantiation");
            e.printStackTrace();
        }

        assert s != null;
        s.addAll(Arrays.asList(args).subList(1,args.length));
        System.out.println(s);
    }
}
