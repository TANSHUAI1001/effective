package leetcode;

/**
 * Created by shuai on 2018/4/8.
 */

/**
 * 9,125
 */
public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int i = 1;
        for (; i < Integer.MAX_VALUE / 10;) {
            if(i*10 > x) break;
            i*=10;
        }
        while (x != 0){
            if(i == 0) return false;
            if(x % 10 != x / i){
                return false;
            }
            x = x % i;
            x = x / 10;
            i = i / 100;
        }
        return true;
    }

    public static boolean isPalindrome(String s) {
        // ^ 匹配输入字符串的开始位置，除非在方括号表达式中使用，此时它表示不接受该字符集合。
        String actual = s.replaceAll("[^A-Za-z0-9]","");
        String rev = new StringBuilder(actual).reverse().toString();
        System.out.println(actual);
        System.out.println(rev);
        return actual.equals(rev);
    }
    public static void main(String[] args) {
//        System.out.println(isPalindrome("12.00,02:1"));
//        System.out.println(isPalindrome("1a,b,c,b,a:1"));
        String s = "1a,b,c,b,a:1";
        System.out.println(s.replaceAll("[^A-Za-z0-9]",""));
    }
}
