package bases.SortAndSearch;

import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.*;

/**
 * Created by shuai on 2017/2/9.
 */
public class Test {
    public static void main(String []args){
//        int prefix = 1;
//        int subffix = 1;
//        System.out.println(prefix++ != 2);
//        System.out.println(++subffix != 2);


        RuleBasedCollator collator = (RuleBasedCollator) Collator.getInstance(Locale.CHINA);
        CollationKey key1 = collator.getCollationKey("张三");
        CollationKey key2 = collator.getCollationKey("李四");
        CollationKey key3 = collator.getCollationKey("李煜");
        System.out.println(key1.getSourceString()+"\n"+
                key2.getSourceString()+"\n"+
                key3.getSourceString()
        );
    }

    public static void useArraysSort(){
        int []arr = {1,2,4,3,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void useCollectionSort(){
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(19);
        list.add(15);
        list.add(16);
        System.out.println(Arrays.toString(list.toArray()));
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }
    public static void testComparatorAndAnd(){
        int a = 0,b = 1,c = 1,d = 1;
//        System.out.println(a&&b);
        //Operator '&&' can not applied to 'int','int'
        if(a < b && c == d){
            System.out.println("OK");
        }
    }
}
