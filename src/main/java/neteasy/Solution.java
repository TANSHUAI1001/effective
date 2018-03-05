package neteasy;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num > 0 && num % 2 == 0){
            cal(num,2);
        }else if(num > 0){
            cal(num,1);
        }
    }

    public static void cal(int num,int n){
        num = (num - n) / 2;
        if(num > 0 && num % 2 == 0){
            cal(num,2);
        }else if(num > 0){
            cal(num,1);
        }
        System.out.print(n);
    }
}
