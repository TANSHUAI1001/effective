package LeetCode;

/**
 * Created by shuai on 2017/2/17.
 * 393. UTF-8 Validation
 */
public class validUtf8Solution {
    public static void main(String[] args) {
//        int []data = {197,130,1};
//        int []data = {235,140,4};
//        int []data = {230,136,145};
//        int []data = {145};
        int []data = {228,189,160,229,165,189,13,10};
        boolean result = validUtf8(data);
        System.out.println("result: "+result);
    }

    public static boolean validUtf8(int[] data){
        int bitCount = 0;
        for (int item:data
             ) {
            if (item >= 192) {
                if(bitCount != 0)
                    return false;
                else if(item >= 240)
                    bitCount = 3;
                else if(item >= 224)
                    bitCount = 2;
                else
                    bitCount = 1;
            }else if(item >= 128){
                --bitCount;
                if(bitCount < 0) return false;
            }else {
                if(bitCount > 0) return false;
            }
        }
        return bitCount == 0;
    }
}
