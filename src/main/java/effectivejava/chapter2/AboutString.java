package effectivejava.chapter2;

/**
 * Created by shuai on 2017/2/17.
 */
public class AboutString {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("shuai");
        s.deleteCharAt(1);
        String s1 = s.toString();
        s.append(" perfect");
        char []c = {'1','2','3'};
        s.append(c,0,2);
        String sss = "789";
        s.append(sss,1,2);
        s.insert(2," ");
        System.out.println(s);
    }
}
