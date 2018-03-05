package leetcode;

/**
 * Created by shuai on 2018/3/5.
 */
public class StringToInteger {
    public int myAtoi(String str) {
//        System.out.println(Integer.MAX_VALUE == 2147483647);
//        System.out.println(Integer.MIN_VALUE == -2147483648);
        int result = 0, len = str.length();
        boolean symbol = false;
        int i = 0;
        while (i < len && str.charAt(i) == ' ') i++;
        if(i < len && str.charAt(i) == '-'){
            symbol = true;
            i++;
        }else if(i < len && str.charAt(i) == '+'){
            symbol = false;
            i++;
        }
        for (; i < len; i++) {
            if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if(result > Integer.MAX_VALUE / 10 ||(result == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')){
                    // == 7 will return MAX in next loop, negative (> 7) ==> (>= 8) also return MIN
                    return symbol ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result = result * 10 + str.charAt(i) - '0';
            }else{
                break;
            }
        }
        return symbol ? -result : result;
    }

    public static void main(String[] args) {
        StringToInteger instance = new StringToInteger();
        System.out.println(instance.myAtoi(" -1010023630o4"));
        System.out.println(Integer.parseInt("1"));
//        if(1){ //compile error
        if(true){
            System.out.println("it is true");
        }
    }
}
