package bases.Traversing;

import LeetCode.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by shuai on 2017/2/8.
 */
public class InOrder {
    public void inorderTraversing(TreeNode tree){
        if (tree == null)return;
        if(tree.getLeft() != null){
            inorderTraversing(tree.getLeft());
        }
        System.out.println(tree.getVal());
        if(tree.getRight() != null){
            inorderTraversing(tree.getRight());
        }
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(list,root);
        return list;
    }

    public static void inorder(List<Integer> list, TreeNode root){
        if (root == null)return;
        if(root.getLeft() != null){
            inorder(list, root.getLeft());
        }
//        System.out.println(root.getVal());
        list.add(root.getVal());
        if(root.getRight() != null){
            inorder(list, root.getRight());
        }
    }
}
