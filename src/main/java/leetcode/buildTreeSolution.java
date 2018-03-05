package leetcode;

/**
 * Created by shuai on 2017/2/9.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */
public class buildTreeSolution {
    public static void main(String []args){
//        int []pre = {5,4,2,1,3,0};
//        int []in = {2,4,1,5,0,3};
//        int []post = {2,1,4,0,3,5};
        int []pre = {1,2,4,5,3,6,7};
        int []in = {4,2,5,1,6,3,7};
        int []post = {4,5,2,6,7,3,1};
        buildTreeFromPreorderAndInorder(pre,in);
    }
    public static TreeNode buildTreeFromPreorderAndInorder(int[] preorder, int[] inorder) {
        /**
         * no duplicates
         * You may assume that duplicates do not exist in the tree.
         */
        return PreorderAndInorder(0,0,inorder.length - 1,
                preorder, inorder);
    }

    public static TreeNode PreorderAndInorder(int preStart, int inStart, int inEnd,
                                       int []preorder, int []inorder){
        if(preStart > preorder.length - 1 || inStart > inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        System.out.println(node.val);
        int mid = 0;
        for (int j = inStart; j <= inEnd; j++) {
            if(inorder[j] == node.val){
                mid = j;
                break;
            }
        }
//        int childLength = mid - inStart;
//        if(childLength <= 0){
//            return node;
//        }
        node.left = PreorderAndInorder(preStart + 1, inStart,mid - 1,
                preorder,inorder);
        node.right = PreorderAndInorder(preStart + mid - inStart + 1,
                mid + 1, inEnd, preorder,inorder);

        return node;
    }

    public TreeNode buildTreeFromInorderAndPostorder(int[] postorder, int[] inorder) {
        /**
         * no duplicates
         * You may assume that duplicates do not exist in the tree.
         */
        if(postorder.length == 0 || inorder.length == 0) return null;
        TreeNode root;
        for (int i = 0; i < postorder.length; i++) {
            root = new TreeNode(postorder[i]);
        }
        return null;
    }

    public TreeNode buildTreeFromPreorderAndPostorder(int[] preorder, int[] postorder) {
        /**
         * no duplicates
         * You may assume that duplicates do not exist in the tree.
         */
        if(preorder.length == 0 || postorder.length == 0) return null;
        TreeNode root;
        for (int i = 0; i < preorder.length; i++) {
            root = new TreeNode(preorder[i]);
        }
        return null;
    }
}
