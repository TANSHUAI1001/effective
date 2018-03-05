package bases.Traversing;

import leetcode.TreeNode;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shuai on 2017/2/14.
 */
public class TestCases {
    public static void main(String []args){
        TreeNode root = new TreeNode(0);

        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        left.setLeft(new TreeNode(3));
        left.setRight(new TreeNode(4));
        right.setLeft(new TreeNode(5));
        right.setRight(new TreeNode(6));

        root.setLeft(left);
        root.setRight(right);

        System.out.println("---------------------"+"\n Inorder");
        InOrder inOrder = new InOrder();
        inOrder.inorderTraversing(root);
        List<Integer>list = inOrder.inorderTraversal(root);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("---------------------"+"\n Preorder");
        PreOrder preOrder = new PreOrder();
        preOrder.preorderTraversing(root);

        System.out.println("---------------------"+"\n Postorder");
        PostOrder postOrder = new PostOrder();
        postOrder.postTraversing(root);

        System.out.println("---------------------"+"\n BFSTraversing");
        BFSTraversing bfsTraversing = new BFSTraversing();
        bfsTraversing.bfsTraversing(root);

        System.out.println("---------------------"+"\n DFSTraversing");
        DFSTraversing dfsTraversing = new DFSTraversing();
        dfsTraversing.dfsTraversing(root);

    }
}
