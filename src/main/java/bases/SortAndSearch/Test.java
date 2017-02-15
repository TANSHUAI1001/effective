package bases.SortAndSearch;

/**
 * Created by shuai on 2017/2/9.
 */
public class Test {
    public static void main(String []args){
        int prefix = 1;
        int subffix = 1;
        System.out.println(prefix++ != 2);
        System.out.println(++subffix != 2);
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
