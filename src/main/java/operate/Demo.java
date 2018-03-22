package operate;

/**
 * Created by shuai on 2018/3/9.
 */
public class Demo {
    public static void main(String[] args) {
        boolean a = false;
        // JAVA的赋值运算是有返回值的，赋了什么值，就返回什么值
        System.out.println(a = false);
        int count = 0;
        int num = 0;
        for (int i = 0; i <= 100 ; i++) {
            num += i;
//            System.out.println(count++);
            count = count++;
        }
        System.out.println(num);
        System.out.println(count);
    }
}
