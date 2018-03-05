package neteasy;

import java.math.BigDecimal;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int len = s.length();
        int arr[] = new int[len];
        int index = 0;
        char temp = ' ';
        for (int i = 0; i < len; i++) {
            if(i == 0){
                arr[0] = 1;
            }else if(temp == s.charAt(i)){
                arr[index]++;
            }else{
                arr[++index] = 1;
            }
            temp = s.charAt(i);

        }

        double sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        double average = sum/(index+1);
        BigDecimal b = new BigDecimal(Double.toString(average));
        double f = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(String.format("%.2f",f));
    }
}
