package neteasy;

import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int temp = num;
        int result = 0;
        while (temp > 0){
            result *= 10;
            result += temp % 10;
            temp = temp / 10;
        }
        System.out.println(result+num);
    }
}
