package bases.sortsearch;

import java.util.Arrays;

/**
 * 选择排序
 * Created by shuai on 2017/2/7.
 */
public class SelectSort {
    public static void main(String []args){
        int []nums = {1,5,6,3,2,4};
        simpleSelectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void simpleSelectSort(int[] arrays){
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrays.length; j++) {
                if(arrays[j] < arrays[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i) swap(arrays,minIndex,i);
        }
    }

    public static void swap(int []nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
