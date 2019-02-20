package leetcode;

/**
 * Created by shuai on 2018/4/27.
 * 10. Regular Expression Matching
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 */
public class RegularExpressionMatching {

    /**
     * 递归判断
     * @param s could be empty and contains only lowercase letters a-z.
     * @param p could be empty and contains only lowercase letters a-z,
     *         and characters like . or *.
     * @return if match or not
     */
    static boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();
        boolean firstMatch = !s.isEmpty()
                && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if(p.length() >= 2 && p.charAt(1) == '*'){
            return firstMatch && isMatch(s.substring(1),p) || isMatch(s,p.substring(2));
        }else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }

    /**
     * 动态规划
     * @param s 字符串
     * @param p 匹配模式
     * @return 是否匹配
     */
    static boolean isMatchByDynamicProgram(String s,String p){

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa","a")); // expected false
        System.out.println(isMatch("aa","a*")); // expected true
        System.out.println(isMatch("ab",".*")); // expected true
        System.out.println(isMatch("aab","c*a*b")); // expected true
        System.out.println(isMatch("mississippi","mis*is*p*.")); // expected false
    }
}
