import java.util.*;

/**
 * Created by yi on 4/24/15.
 */
public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        if (root == null) return 0;
        TreeNode rightMost = root;
        int level = 0;
        que.add(root);
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.left != null)
                que.add(node.left);
            if (node.right != null)
                que.add(node.right);
            if (node.right == null && node.left == null)
                break;
            if (node == rightMost) {
                rightMost = node.right;
                level++;
            }
        }
        return level;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
