package bases.SortAndSearch;

/**
 * Created by shuai on 2017/2/7.
 */
public class SequentialSearch {
    public static void main(String []args){
        int []array = {1,3,4,5,2,10};
    }

    public static int sequentialSearch(int target, int []array){
        for (int i = 0; i < array.length; i++) {
            if(target == array[i]){
                return i;
            }
        }
        return -1;
    }
}
