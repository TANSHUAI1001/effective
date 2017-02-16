package LeetCode;

import bases.Traversing.BFSTraversing;
import bases.Traversing.DFSTraversing;

/**
 * Created by shuai on 2017/2/16.
 */
public class deleteNodeSolution {
    public static void main(String []args){
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
        TreeNode root = new TreeNode(5);
        TreeNode left = new TreeNode(3);
        left.left = new TreeNode(2);
        left.right = new TreeNode(4);
        TreeNode right = new TreeNode(6);
        right.right = new TreeNode(7);
        root.left = left;
        root.right = right;

        // there is a bug in this , Traverse root and newRoot is different !!
        // 研究结果 ==》 extend.ConsiderTreeNode
        TreeNode newRoot = deleteNode2(root,5);
        BFSTraversing bfsTraversing = new BFSTraversing();
        bfsTraversing.bfsTraversing(root);
//        DFSTraversing dfsTraversing = new DFSTraversing();
//        dfsTraversing.dfsTraversing(root);
    }

    public static TreeNode deleteNode2(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }

    public static TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return root;
        TreeNode node = root;
        TreeNode parent = node;
        while (node != null){
            if(node.val > key){
                parent = node;
                node = node.left;
            }else if(node.val < key){
                parent = node;
                node = node.right;
            }else {
                if(parent.val > node.val){
                    if(node.right != null){
                        parent.left = node.right;
                        TreeNode helper = node.right;
                        while (helper.left != null){
                            helper = helper.left;
                        }
                        helper.left = node.left;
                    }else if(node.left != null){
                        parent.left = node.left;
                    }else {
                        parent.left = null;
                    }

                }else if(parent.val < node.val){
                    if(node.right != null){
                        parent.right = node.right;
                        TreeNode helper = node.right;
                        while (helper.left != null){
                            helper = helper.left;
                        }
                        helper.left = node.left;
                    }else if(node.left != null){
                        parent.right = node.left;
                    }else {
                        parent.right = null;
                    }
                }else {
                    //parent equals its child
                    //it is root
                    if(node.right != null){
                        TreeNode left = root.left;
                        root = node.right;
                        TreeNode helper = root;
                        while (helper.left != null){
                            helper = helper.left;
                        }
                        helper.left = left;
                    }else if(node.left != null){
                        root = node.left;
                    }else {
                        root = null;
                    }
                }
                break;
            }
        }
        return root;
    }
}
