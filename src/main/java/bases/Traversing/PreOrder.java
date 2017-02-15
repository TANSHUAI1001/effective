package bases.Traversing;

import LeetCode.TreeNode;


/**
 * Created by shuai on 2017/2/8.
 */
public class PreOrder {
    public void preorderTraversing(TreeNode tree){
        if (tree == null)return;
        System.out.println(tree.getVal());
        if(tree.getLeft() != null){
            preorderTraversing(tree.getLeft());
        }
        if(tree.getRight() != null){
            preorderTraversing(tree.getRight());
        }
    }
}
