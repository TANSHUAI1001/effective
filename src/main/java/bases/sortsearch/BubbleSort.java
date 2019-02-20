package bases.sortsearch;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/7.
 */
public class BubbleSort {
    public static void main(String []args){
        int []arr = {10,11,12,9,8,10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int []arrays){
        if(arrays.length <= 1) return;
        for (int i = 0; i < arrays.length; i++) {
            /**
             * 这是最暴力的办法
             * for (int j = i + 1; j < arrays.length; j++) {
             *      if(arrays[i] > arrays[j]){
             *                swap(arrays,i,j);
             *             }
             *           }
             */
            for (int j = arrays.length - 1; j > i; j--) {
                if(arrays[j] < arrays[j-1]){
                    swap(arrays,j,j-1);
                }
            }


        }
    }

    public static void swap(int []nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
