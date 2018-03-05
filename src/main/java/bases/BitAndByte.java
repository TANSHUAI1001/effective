package bases;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * Created by shuai on 2017/4/17.
 */
public class BitAndByte {
    public static void main(String[] args) {
//        String s = "我是shuai我是tan我";
//        for (int i = 1; i <= 12; i++) {
//            System.out.println(i+":"+getSub(s,i));
//        }
////        System.out.println(getSub(s,8));
//        System.out.println(s.length()+" "+s.getBytes().length);
//        // 中文GBK占两字节，UTF-8占三字节
////        String ss = "中文全都是";
//        try {
//            System.out.println(Arrays.toString(s.getBytes("UTF-8")));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        BitAndByte bab = new BitAndByte();
        bab.test();
    }

    public void test(){
        String str = "中文";

        char temp = str.charAt(1);
        System.out.println(temp+0);
        System.out.println(110);
    }
    public static String getSub(String s,int n){
        StringBuilder str = new StringBuilder();
        int index = 0,counter = 1;
        char temp;
        for (int i = 0; i < n; i++) {
            temp = s.charAt(index);
            if(temp > 0 && temp < 256){
                str.append(s.substring(index,index+1));
                ++index;
            }else if(counter > 0){
                counter--;
            }else {
                str.append(s.substring(index,index+1));
                ++index;
                counter = 1;
            }
        }
        return str.toString();
    }
}
