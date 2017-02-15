package LeetCode;

import java.util.Stack;

/**
 * Created by shuai on 2017/2/8.
 */
public class findFrequentTreeSumSolution {
    public static void main(String []args){
        TreeNode t = new TreeNode(1);
        findFrequentTreeSum(t);
    }

    public static int[] findFrequentTreeSum(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tr = root;
        int num = 0;
        while (tr != null){
            stack.push(tr);
            if(tr.left != null){
                num++;
                tr = tr.left;
            }else if(num >= 0){
                tr = stack.elementAt(num).right;
                num--;
            }

        }
        return null;
    }
}
