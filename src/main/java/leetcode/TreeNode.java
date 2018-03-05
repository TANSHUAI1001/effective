package leetcode;

/**
 * Created by shuai on 2017/2/8.
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int x) { val = x; }
    public void setLeft(TreeNode left){this.left = left;}
    public void setRight(TreeNode right){this.right = right;}
    public TreeNode getLeft(){return this.left;}
    public TreeNode getRight(){return this.right;}
    public int getVal(){return this.val;}

    /**
     * 提供改变自身的方法，才可以在函数传递参数的过程中改变自身，
     * 要不然就相当于值传递；
     * @param node
     * @return
     */
    public TreeNode reset(TreeNode node){
        this.val = node.val;
        this.left = node.left;
        this.right = node.right;
        return this;
    }
}
