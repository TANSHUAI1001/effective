package operate;

/**
 * Created by shuai on 2018/3/9.
 */
public class Demo {

    private static Long func(int n){
        if(n > 1)
            return n * func(n-1);
        else
            return 1L;
    }
    public static void main(String[] args) {
        System.out.println(Long.BYTES);
        System.out.println(Integer.BYTES);
        int n = 14;
        long []array = new long[n+1];
        array[0] = 1;
        for (int i = 1; i <= n; i++) {
            array[i] = func(i);
            if(array[i] / array[i-1] != i){
                System.out.println("数值越界");
                break;
            }
            System.out.println(i+":"+array[i]);
        }

//        boolean a = false;
//        // JAVA的赋值运算是有返回值的，赋了什么值，就返回什么值
//        System.out.println(a = false);
//        int count = 0;
//        int num = 0;
//        for (int i = 0; i <= 100 ; i++) {
//            num += i;
////            System.out.println(count++);
//            count = count++;
//        }
//        System.out.println(num);
//        System.out.println(count);
    }
}
