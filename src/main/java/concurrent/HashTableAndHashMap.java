package concurrent;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by shuai on 2018/3/23.
 */
public class HashTableAndHashMap {
    public static void main(String[] args) {
        HashMap<Object,Object> hm = new HashMap<>();
        hm.put("s","shuai");
        System.out.println(hm.containsKey("s"));
        System.out.println(hm.containsValue("shuai"));

        Hashtable<String,String> ht = new Hashtable<>();
        ht.put("t","tan");
        System.out.println(ht.contains("tan"));
        System.out.println(ht.containsKey("t"));
        System.out.println(ht.containsValue("tan"));

    }
}
