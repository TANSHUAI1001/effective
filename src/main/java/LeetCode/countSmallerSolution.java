package LeetCode;

import java.util.*;

/**
 * Created by shuai on 2017/2/16.
 * 315. Count of Smaller Numbers After Self
 */
public class countSmallerSolution {
    public static void main(String[] args) {
//        int []nums = {5,2,6,1};
//        int []nums = {-1,-1};
//        int []nums = {-1,0};
//        int []nums = {2,0,1};
//        int []nums = {1,0,2};
//        int []nums = {1,2,3};
        int []nums = {26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,
                98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41};
//        [10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0]
        List<Integer> result = countSmaller5(nums);
        System.out.println(Arrays.toString(result.toArray()));
        System.out.println("rl "+result.toArray().length+" nl "+nums.length);
    }

    public static int[] countSmaller(int []nums){
        if(nums.length < 1) return null;
        for (int i = 0; i < nums.length; i++) {
            int self = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if(self > nums[j]) ++count;
            }
            nums[i] = count;
        }
        return nums;
    }

    public static List<Integer> countSmaller2(int []nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int self = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if(self > nums[j]) ++count;
            }
            list.add(count);
        }
        return list;
    }

    public static List<Integer> countSmaller3(int []nums){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(0);
            for (int j = 0; j < i; j++) {
                if(nums[j] > nums[i]){
                    list.set(j,list.get(j) + 1);
                }
            }
        }
        return list;
    }

    public static List<Integer> countSmaller4(int []nums){
        List<Integer> list = new ArrayList<>();
        List<Integer> sortList = new ArrayList<>();
        int end = nums.length - 1;
        if(end < 0) return list;
        int max = nums[end],min = nums[end];
        sortList.add(nums[end]);
        list.add(0);
        for (int i = end - 1; i >= 0 ; --i) {
            if(nums[i] > max){
                list.add(0,end - i);
                sortList.add(0,nums[i]);
                max = sortList.get(0);
                min = sortList.get(sortList.size() - 1);
                continue;
            }
            if(nums[i] <= min){
                list.add(0,0);
                sortList.add(nums[i]);
                max = sortList.get(0);
                min = sortList.get(sortList.size() - 1);
                continue;
            }
            int len = sortList.size();
            for (int j = 0; j < len - 1; ++j) {
                if(sortList.get(j) >= nums[i] && sortList.get(j+1) < nums[i]){
                    list.add(0,len - j - 1);
                    sortList.add(j+1,nums[i]);
                    max = sortList.get(0);
                    min = sortList.get(sortList.size() - 1);
                    break;
                }
            }
        }

        return list;
    }

     class Node {
        Node left, right;
        int val, sum, dup = 1;
        public Node getLeft() {
            return left;
        }

        Node(int v, int s) {
            val = v;
            sum = s;
        }
    }
    public static List<Integer> countSmaller5(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    private static Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new countSmallerSolution().new Node(num,0);
//            node = new Node(num, 0);
            ans[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}
