package extend;

/**
 * Created by shuai on 2017/2/23.
 */
public class Test {
    public static void main(String[] args) {
//        int i=2; i += i -= i*i;
//        System.out.println(i);
//
//        int k = 10;
//        k -= k += k -= k*k;
//        System.out.println(k);
        testString();
    }

    public static void testString(){
        String s1 = "1001";
        String s2 = "1";
        String s3 = "0";
        System.out.println(s1.startsWith(s2));
        System.out.println(s1.startsWith(s3,1));
        System.out.println(s1.startsWith(s2+s3));
        System.out.println(s1.endsWith(s3+s2));

        char []cc = {'1','2','3'};
        String ss = String.valueOf(cc);
        System.out.println(ss);
//        char []cs = "12344"; // C++的写法

//        int []ii = {1,2,3,4,5};
//        String si = String.valueOf(ii);// not work !
//        System.out.println(si);


    }
}
