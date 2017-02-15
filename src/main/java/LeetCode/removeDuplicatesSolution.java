package LeetCode;

import java.util.Arrays;

/**
 * Created by shuai on 2017/2/6.
 * 26. Remove Duplicates from Sorted Array
 */
public class removeDuplicatesSolution {
    public static void main(String args[]){
        int []nums = {1,1,1,2,2,3,4,5,5,5};
//        int []nums = {};
        int result = removeDuplicatesWithON(nums);
        System.out.println("length : "+result);
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicatesWithON(int[] nums) { // more effective !!! O(N)
        int length = nums.length;
        if(length < 2){
            return length;
        }
        int id = 1;
        for(int i = 1; i < length; i++)
            if(nums[i] != nums[i-1]) nums[id++] = nums[i];
        return id;
    }

    public static int removeDuplicates(int[] nums) { //数组无损，时间O(N^2)
        int length = nums.length;
        if(length < 2){
            return length;
        }
        int left = nums[0];

        for(int i = 1; i < length; i++){
            if(left == nums[i]){
                length--;
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length - 1] = left;
                i--;
            }else {
                left = nums[i];
            }
        }
        return length;
    }
}
