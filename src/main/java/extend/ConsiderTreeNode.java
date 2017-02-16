package extend;

import LeetCode.TreeNode;

/**
 * Created by shuai on 2017/2/16.
 */
public class ConsiderTreeNode {
    public static void main(String []args){
        TreeNode root = new TreeNode(10);
        root.setRight(new TreeNode(5));
        considering(root);
        System.out.println(root.getVal());
        change(root);
        System.out.println(root.getVal());
    }

    public static void considering(TreeNode root){
        root = root.getRight();
    }

    public static void change(TreeNode root){
        root.reset(root.getRight());
    }
}
