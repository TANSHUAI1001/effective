package analysis;

import java.math.BigDecimal;

/**
 * 大数相乘
 * Created by shuai on 2017/2/23.
 */
public class LargeIntegerMultiplication {
    public static void main(String[] args) {
        LargeIntegerMultiplication l = new LargeIntegerMultiplication();
        int result = l.multiplication(1,4);
        System.out.println(result);
//        test();
    }

    public int multiplication(int a, int b){
        if(a/100 == 0 && b/100 == 0){
            int a1 = a/10,a0 = a%10;
            int b1 = b/10,b0 = b%10;
            int c2 = a1*b1,c0 = a0*b0 ,c1 = (a1+a0)*(b1+b0)-(c2+c0);
            int mul = c2*100 + c1*10 + c0;
            return mul;
        }
        int len = Math.max(String.valueOf(a).length(),String.valueOf(b).length());
        int a1 = (int) (a/Math.pow(10,len/2)),a0 = (int) (a%Math.pow(10,len/2));
        int b1 = (int) (b/Math.pow(10,len/2)),b0 = (int) (b%Math.pow(10,len/2));
        int c2 = multiplication(a1,b1),c0 = multiplication(a0,b0) ,c1 = multiplication((a1+a0),(b1+b0))-(c2+c0);
        int result = (int) (c2*Math.pow(10,len) + c1*Math.pow(10,len/2) + c0);
        return result;
    }

    public static void test(){
        int a = (int) (12345/Math.pow(10,2));
        int b = (int) (12345%Math.pow(10,2));
        System.out.println(a+" "+b+" "+a+b);
    }
}
