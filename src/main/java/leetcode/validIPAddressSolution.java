package leetcode;

/**
 * Created by shuai on 2017/2/28.
 * 468. Validate IP Address
 */
public class validIPAddressSolution {
    public static void main(String[] args) {
        validIPAddressSolution v = new validIPAddressSolution();
//        System.out.println(v.validIPAddress("121.110.169.01."));
        System.out.println(v.validIPAddress("2001:0db8:85a3::0:8a2e:0370:7334:"));
//        System.out.println(v.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"));
    }

    public String validIPAddress(String IP) {
        if(IP.length() > 39) return "Neither";
        String []array1,array2;
        array1 = IP.split("\\.");
        array2 = IP.split(":");
        if(array1.length > 1 && array2.length > 1)return "Neither";
        else if(array2.length == 1 && array1.length == 4){
            if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return "Neither";
            for (int i = 0; i < 4; i++) {
                if(array1[i].length() == 0 || array1[i].length() > 3) return "Neither";

                for (int j = 0; j < array1[i].length(); j++) {
                    if(!Character.isDigit(array1[i].charAt(j))) return "Neither";
                }
                if(Integer.valueOf(array1[i]) > 0xff
                        || (array1[i].charAt(0) == '0' && array1[i].length() > 1))
                    return "Neither";
            }
            return "IPv4";
        }
        else if(array2.length == 8 && array1.length == 1){
            if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return "Neither";
            for (int i = 0; i < 8; i++) {
                if(array2[i].length() == 0 || array2[i].length() > 4) return "Neither";
                if(array2[i].charAt(0) == '0' && array2[i].length() > 4) return "Neither";
                for (int j = 0; j < array2[i].length(); j++) {
                    char c = array2[i].charAt(j);
                    if(!(Character.isLetter(c) &&
                            ((c - 'a' >= 0 && c - 'f' <= 0) || (c - 'A' >= 0 && c - 'F' <= 0)))
                            && !Character.isDigit(c))
                        return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }

    public boolean isLeadingZero(String str){

        return false;
    }
}
