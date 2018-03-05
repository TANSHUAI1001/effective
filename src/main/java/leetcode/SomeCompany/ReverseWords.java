package leetcode.SomeCompany;

/**
 * Created by shuai on 2017/2/20.
 * Given a sentence, like 'MyNameIsTom'.
 * Yeah, there is no space in the sentence.
 * And also given a big dictionary that contains all the words.
 * Please write a function to find out those word and reverse it .
 * So the result should be 'yMemaNsImoT'.
 */
public class ReverseWords {
    public static void main(String[] args) {
        String s = "MyNameIsTom";
        String rs = reverse(s);
        System.out.println(rs);
    }

    public static String reverse(String str){
        int len = str.length();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; ++i) {
            if(i == len - 1 || Character.isUpperCase(str.charAt(i + 1))){
                for (int j = i; j >= start; --j) {
                    sb.append(str.charAt(j));
                }
                start = i + 1;
            }
        }

        return sb.toString();
    }
}
