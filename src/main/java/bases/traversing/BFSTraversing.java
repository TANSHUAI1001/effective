package bases.traversing;

import leetcode.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by shuai on 2017/2/7.
 */
public class BFSTraversing {
    public void bfsTraversing(TreeNode root){
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        bfs(queue);
    }
    public void bfs(Queue<TreeNode> queue){
        TreeNode node = queue.poll();
        System.out.println(node.getVal());
        if(node.getLeft() != null){
            queue.offer(node.getLeft());
        }
        if(node.getRight() != null){
            queue.offer(node.getRight());
        }
        if(queue.size() > 0){
            bfs(queue);
        }
    }
}
