package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shuai on 2017/2/4.
 */
public class longestConsecutiveSolution {
    public static void main(String args[]){
//        int []nums = {100,4,200,1,3,2};
        int []nums = {1,2,0,1};
        int result = longestConsecutive(nums);
        System.out.println("longest "+result);
    }
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> seq = new HashMap<>();
        int longest = 0;
        for(int i : nums){
            if(seq.containsKey(i)){
                continue;
            }else {
                int left = seq.containsKey(i-1) ? seq.get(i - 1) : 0;
                int right = seq.containsKey(i+1) ? seq.get(i + 1) : 0;
                int sum = left + right + 1;
                seq.put(i, sum);
                longest = longest > sum ? longest : sum;

                // important, update sequence sides!!!
                seq.put(i - left, sum);
                seq.put(i + right, sum);
            }
        }
        return longest;
    }
}
