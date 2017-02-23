package LeetCode;

import java.util.Map;

/**
 * Created by shuai on 2017/2/23.
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers div = new DivideTwoIntegers();
        int result = div.divide(36,3);
        System.out.println("result: "+result);
//        test();
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long temp = absDivisor;
        int count = 0,result;
        while (temp <= absDividend){
            temp = absDivisor << count;
            count = count == 0?1:count<<1;
        }
        result = 1 << count;
        absDividend -= absDivisor << count;

        while (absDividend > 0){
            absDividend -= absDivisor;
            ++result;
        }
        return sign == 1 ? result : -result;
    }

    public static void test(){
        long l = 123567890456789L;
        float f = 0.12f;
        System.out.println(-15 >> 4);
        long x = Math.abs((long) Integer.MIN_VALUE);
        long y = Math.abs(Integer.MIN_VALUE);
        System.out.println("x: "+x+" y: "+y+" min: "+Integer.MIN_VALUE);
    }
}
