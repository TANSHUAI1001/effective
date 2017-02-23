package LeetCode.SomeCompany;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/20.
 * Given a number T, print out all possible ways to get to T.
 * For example,
 * T = 5
 * 1 + 1 + 1 + 1
 * 2 + 1 + 1 + 1
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 4 + 1
 * 3 + 2
 * note that 3 + 2 is same as 2 + 3, so you don't have to print both cases
 * What is the time complexity? Brute force is not allowed.
 */
public class WaysToNum {
    public static void main(String[] args) {
        int num = 6;
        int maxi = num - 1;
        seperate("",num,maxi);
//        ways(10);
    }

    public static void ways(int n){
        int []array = new int[n];
        Arrays.fill(array,1);
        System.out.println(Arrays.toString(array));
    }

    public static void seperate(String pref, int n, int maxi){
        if(n==0){
            System.out.println(pref);
            return;
        }
        for(int i=1; i<=maxi && i<=n; i++){
            seperate(pref+(pref==""?"":"+")+i, n-i,i);
        }

    }
}
