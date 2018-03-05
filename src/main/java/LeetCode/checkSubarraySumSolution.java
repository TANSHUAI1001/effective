package LeetCode;

/**
 * Created by shuai on 2017/2/28.
 * 523. Continuous Subarray Sum
 */
public class checkSubarraySumSolution {
    public static void main(String[] args) {

    }

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0) return false;
        if(k == Integer.MIN_VALUE || k == Integer.MAX_VALUE) return false;
        if(k < 0) k = Math.abs(k);
        int sum;
        for (int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum == 0 && k == 0) return true;
                else if(k == 0 && sum != 0)return false;
                else if(sum % k == 0) return true;
            }
        }
        return false;
    }
}
