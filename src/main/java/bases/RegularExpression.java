package bases;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shuai on 2017/2/28.
 */
public class RegularExpression {
    public static void main(String[] args) {
        RegularExpression r = new RegularExpression();
        r.validateIP("");
//        r.match();
    }
    public void validateIP(String IP){
        String regex = "(\\d+\\.){3}\\d+";
        String regex1 = "(([[0-1][0-9][0-9]]|[2[0-4][0-9]]|25[0-5])\\.){3}([[0-1][0-9][0-9]] | [2[0-4][0-9]] | 25[0-5])";
        String regex2 = "[0-1]?[0-9]?[0-9]";
        Pattern pattern = Pattern.compile(regex2);
//        boolean result = pattern.matcher("192.168.1.1").matches();
        for(int i = 0; i < 199;i++){
            boolean result = pattern.matcher(String.valueOf(i)).matches();
            if(!result) System.out.println(i + ":" + result);
        }
//        boolean result = pattern.matcher("00").matches();
//        System.out.println(result);
//        String []s = pattern.split("a1b23c456d7890e");
//        System.out.println(Arrays.toString(s));

    }

    public void match(){
        String s = "abcd";
        System.out.println(s.matches("[abcd]*"));
    }
    public void test(){
        String rex = ".bc";
        Pattern pattern = Pattern.compile(rex);
        Matcher m = pattern.matcher("abccbc");
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
