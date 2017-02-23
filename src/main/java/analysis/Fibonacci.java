package analysis;

import mycollection.MultiThread.Main;

/**
 * Created by shuai on 2017/2/22.
 */
public class Fibonacci {
    public static void main(String[] args) {
        int num = 10;
//        formula(num);
//        recursive(num);
        optimization(num);
    }

    public static void formula(int n){
        double fn;
        for (int i = 0; i < n; ++i) {
            fn = (1/Math.sqrt(5)) * Math.pow((1 + Math.sqrt(5))/2,i);
            System.out.println(fn+" --> "+Math.round(fn));
        }
    }

    public static void recursive(int n){
        for (int i = 0; i < n; i++) {
            System.out.println(fn(i));
        }
    }

    public static int fn(int n){
        if(n == 0 || n == 1) return n;
        return fn(n - 1) + fn(n - 2);
    }

    public static void optimization(int n){
        int a = -1,b = -1, result;
        for (int i = 0; i < n; ++i) {
            result = fnOptimization(i,a,b);
            a = b;
            b = result;
            System.out.println(result);
        }
    }

    public static int fnOptimization(int n, int a, int b){
        if(a >= 0 && b >= 1){
            return a+b;
        }
        return n;
    }


}
