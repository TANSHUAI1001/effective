package extend;

/**
 * Created by shuai on 2017/2/23.
 */
public class Test {
    public static void main(String[] args) {
        int i=2; i += i -= i*i;
        System.out.println(i);

        int k = 10;
        k -= k += k -= k*k;
        System.out.println(k);
    }
}
