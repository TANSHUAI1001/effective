package bases.Traversing;

import LeetCode.TreeNode;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shuai on 2017/2/7.
 */
public class DFSTraversing {
    public void dfsTraversing(TreeNode root){

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        dfs(stack);
    }
    public void dfs(Stack<TreeNode> stack){
        TreeNode node = stack.pop();
        System.out.println(node.getVal());
        if(node.getRight() != null){
            stack.push(node.getRight());
        }
        if(node.getLeft() != null){
            stack.push(node.getLeft());
        }

        if(stack.size() > 0){
            dfs(stack);
        }
    }
}
