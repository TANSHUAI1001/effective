package LeetCode;

/**
 * Created by shuai on 2017/2/14.
 * 306. Additive Number
 */
public class isAdditiveNumberSolution {
    public static void main(String []args){
        String num = "112358";
        isAdditiveNumber(num);
    }

    public static boolean isAdditiveNumber(String num) {
        int len = num.length();
        if(len < 3){
            return false;
        }
        int first = 0;
        int second = 1;
        int third = 2;
        int last = 3;

        while (last < len){
            int firstNum = Integer.parseInt(num.substring(first,second));
            int secondNum = Integer.parseInt(num.substring(second,third));
            int thirdNum = Integer.parseInt(num.substring(third,last));

            if(firstNum + secondNum == thirdNum){
                first = second;
                second = third;
                third = last;
                last++;
            }else if(firstNum + secondNum > thirdNum){
                return false;
            }else if(firstNum + secondNum < thirdNum){
                last++;
            }
        }

        return false;
    }
}
