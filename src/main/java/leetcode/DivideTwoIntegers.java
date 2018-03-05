package leetcode;

/**
 * Created by shuai on 2017/2/23.
 * 29. Divide Two Integers
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        DivideTwoIntegers div = new DivideTwoIntegers();
        int result = div.divide(-2147483648,-1);
        System.out.println("result: "+result);
//        test();
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == 0) return 0;
        int sign = 1;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            sign = -1;
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long temp = absDivisor;
        long count = 0,result = 0L;
        while (temp <= absDividend && absDivisor << count+1 <= absDividend){
            temp = absDivisor << count;
            ++count;
        }
        result = count == 0?0:1 << count;
        absDividend -= count == 0?0:absDivisor << count;

        while (absDividend >= absDivisor){
            absDividend -= absDivisor;
            ++result;
        }
        result = sign == 1 ? result : -result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return Integer.MAX_VALUE;
        return (int) result;
    }

    public static void test(){
        System.out.println((3<<3)+" "+(3<<8));
//        long l = 123567890456789L;
//        float f = 0.12f;
//        System.out.println(-15 >> 4);
//        long x = Math.abs((long) Integer.MIN_VALUE);
//        long y = Math.abs(Integer.MIN_VALUE);
//        System.out.println("x: "+x+" y: "+y+" min: "+Integer.MIN_VALUE);
    }
}
