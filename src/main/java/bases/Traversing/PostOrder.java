package bases.Traversing;

import leetcode.TreeNode;


/**
 * Created by shuai on 2017/2/8.
 */
public class PostOrder {
    public void postTraversing(TreeNode tree){
        if (tree == null)return;
        if(tree.getLeft() != null){
            postTraversing(tree.getLeft());
        }
        if(tree.getRight() != null){
            postTraversing(tree.getRight());
        }
        System.out.println(tree.getVal());
    }
}
