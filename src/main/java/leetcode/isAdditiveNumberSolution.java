package leetcode;

import java.math.BigInteger;

/**
 * Created by shuai on 2017/2/14.
 * 306. Additive Number
 */
public class isAdditiveNumberSolution {
    public static void main(String []args){
        String num = "199100199";
//        BigInteger n = new BigInteger("1001",2);
//        System.out.println(n);
        isAdditiveNumberSolution ians = new isAdditiveNumberSolution();
        System.out.println(ians.isAdditiveNumber2(num));
    }

    public boolean isAdditiveNumber(String num) {
        /**
         * Recursive 递归：调用函数自身
         * If no overflow,
         * instead of BigInteger we can consider to use Long which is a lot faster.
         */
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i) {
            if (num.charAt(0) == '0' && i > 1) return false;
            BigInteger x1 = new BigInteger(num.substring(0, i));
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
                if (num.charAt(i) == '0' && j > 1) break;
                BigInteger x2 = new BigInteger(num.substring(i, i + j));
                if (isValid(x1, x2, j + i, num)) return true;
            }
        }
        return false;
    }
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
        if (start == num.length()) return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
    }

    public boolean isAdditiveNumber2(String num) {
        // Iterative 迭代：输出作为输入，更新变量值
        int n = num.length();
        for (int i = 1; i <= n / 2; ++i)
            for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
                if (isValid2(i, j, num)) return true;
        //时间复杂化度接近N*N*N
        return false;
    }
    private boolean isValid2(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        String sum;
        BigInteger x1 = new BigInteger(num.substring(0, i));
        BigInteger x2 = new BigInteger(num.substring(i, i + j));
        for (int start = i + j; start != num.length(); start += sum.length()) {
            x2 = x2.add(x1);
            x1 = x2.subtract(x1);
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        return true;
    }

    /**
     * 迭代与递归的区别：
     * 求解n！的值：
     * 迭代:
     * //循环语句迭代！
     * mul = n;
     * mul = mul * (n-1);
     * mul = mul * (n-2);
     * ...
     * mul = mul * 1;
     *
     * 递归：
     * f(n){
     * //停止循环条件！
     *     n*f(n-1);
     * }
     */
}
