package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuai on 2018/4/9.
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        if(s.length() <= 0) return 0;
        // I 1,V 5,X 10,L 50,C 100,D 500,M 1000
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int value = map.get(s.charAt(0));
        if(s.length() == 1) return value;
        for (int i = 1; i < s.length(); i++) {
            if(map.get(s.charAt(i)) > map.get(s.charAt(i-1))){
                value += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i-1));
            }else{
                value += map.get(s.charAt(i));
            }
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCVI"));
    }
}
