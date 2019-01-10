package bases.sortsearch;

import leetcode.ListNode;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 */
public class InsertSort {

    public static void main(String []args){
        int[] array = {46,79,56,38,40,84};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
      public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = i - 1; j >= 0 ; j--) {
                if(array[j] > temp){
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
