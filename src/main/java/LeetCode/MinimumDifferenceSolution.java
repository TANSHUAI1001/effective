package LeetCode;

import java.util.TreeSet;

/**
 * Created by shuai on 2017/2/27.
 * 530. Minimum Absolute Difference in BST
 */
public class MinimumDifferenceSolution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    TreeSet<Integer> set = new TreeSet<>();

    public static void main(String[] args) {
        MinimumDifferenceSolution mds = new MinimumDifferenceSolution();
        TreeNode root = new TreeNode(10);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(15);
        left.left = new TreeNode(1);
        left.right = new TreeNode(9);
        right.left = new TreeNode(13);
        right.right = new TreeNode(20);
        root.left = left;root.right = right;

        int result = mds.getMinimumDifference(root);
        System.out.println(result);
        int result2 = mds.getMinFromNotBST(root);
        System.out.println(result2);
    }

    public int getMinimumDifference(TreeNode root) { // Inorder,中序遍历已将所有节点按升序排列
        if (root == null) return min;

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
//        if(root == null || (root.left == null && root.right == null))return 0;
//        int minimum = Integer.MAX_VALUE;
//
//        return minimum;
    }

    public int getMinFromNotBST(TreeNode root){ // TreeSet is an ordered collection
        if (root == null) return min;

        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.floor(root.val)));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, Math.abs(root.val - set.ceiling(root.val)));
            }
        }

        set.add(root.val);

        getMinFromNotBST(root.left);
        getMinFromNotBST(root.right);

        return min;
    }
}
