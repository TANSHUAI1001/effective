package bases;

import java.text.DecimalFormat;
import java.util.zip.DeflaterOutputStream;

/**
 * Created by shuai on 2017/4/17.
 */

/**
 *  double,float 的内存存储方式与其他数据类型不同，所以计算就会导致精度缺失，
 *  移位指数表示，
 *  float有32字节 (32 bits == 4 bytes)
 *  31(符号位) 30 ~ 23 (8位指数) 22 ~ 0 (23 + 1 位二进制有效数字) ， 指数移位127
 *  double有64字节 (64 bits == 8 bytes)
 *  63(符号位) 62 ~ 52 (11位指数) 51 ~ 0 (52 + 1 位二进制有效数字) ， 指数移位1023
 */
public class LongOrDouble {
    public static void main(String[] args) {
        LongOrDouble ld = new LongOrDouble();
        ld.method1();
        ld.method();
    }

    public void method1(){
        double test1 = 1.2345678;
        System.out.println(Math.round(test1*1000)/1000.0);
        DecimalFormat df = new DecimalFormat("#.000");
        double test2 = Double.parseDouble(df.format(test1));
        System.out.println(test2);

    }

    public void method(){
        int a = 1;
        float b = 2.01f;
        double c = 3.1415;
        char d = 'a';
        long e = 12L;
        double result1 = a+a/b+a/c+d+e;
        float result2 = (float) (a+a/b+a/c+d+e);
        long result3 = (long) (a+a/b+a/c+d+e);
        System.out.println(result1+" "+result2+" "+result3);
        double value = Double.MAX_VALUE * Double.MIN_VALUE;
        System.out.println("max * min = "+value);
        System.out.println("positive : "+(Double.MAX_VALUE > Long.MAX_VALUE));
        System.out.println("double min value : "+Double.MIN_VALUE);
        double neg = -Double.MAX_VALUE;
        System.out.println("double negative : " + neg);
        System.out.println("double max value : " + Double.MAX_VALUE);
        System.out.println("double min value : " + Double.MIN_VALUE);
        long max = Long.MAX_VALUE;
        long min = Long.MIN_VALUE;
        System.out.println("Long max value : "+max);
        System.out.println("Long min value : "+min);
        System.out.println("negative : "+(neg < min));
        System.out.println(Double.MAX_VALUE > Long.MAX_VALUE);
        System.out.println(
                "double bytes : "+Double.BYTES +" long bytes : "+Long.BYTES);

        int mi = Integer.MAX_VALUE;
        System.out.println("integer : "+mi+" "+((mi+1) == Integer.MIN_VALUE));
    }
}
