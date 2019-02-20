package leetcode;

import java.util.Arrays;

public class RotateArray {
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


    public static void rotate(int[] nums, int k) {
        if(k <= 0) return;
        int tmp,len = nums.length,j = len - 1 + k*len,index = 1;
        tmp = nums[len-index];
        for (int i = 0;j>0 && i < len && index < len; j=j-k,i++) {
            if((j-k)%len == len-index){
                nums[j%len] = tmp;
                ++index;
                --j;
                tmp = nums[len-index];
            }else{
                nums[j%len] = nums[(j-k)%len];
            }

        }
    }
    public static void main(String[] args) {
        int nums[] = {1};
        rotate(nums,1);
        System.out.println(Arrays.toString(nums));
    }
}
