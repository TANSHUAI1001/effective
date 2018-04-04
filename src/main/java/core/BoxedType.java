package core;

/**
 * Created by shuai on 2018/3/23.
 */
public class BoxedType {
    public static void main(String[] args) {
        Integer i = 42;
        Long l = 42L;
        Double d = 42.0;

//        (i == l);
//        (i == d);
//        (l == d);
        /**
         * source code :
         * if (obj instanceof Integer/Double/Long) {
         *   ...
         * }
         * return false;
         */
        System.out.println(i.equals(d)); // false
        System.out.println(d.equals(l)); // false
        System.out.println(i.equals(l)); // false
        System.out.println(l.equals(42L)); // true


    }
}
