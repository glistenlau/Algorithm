

/**
 * Created by yi on 4/24/15.
 */
public class ValidBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValidNode(root, null, null);
    }

    private boolean isValidNode(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        return (min == null || root.val > min) && (max == null || root.val < max) && isValidNode(root.left, root.val, min) && isValidNode(root.right, max, root.val);
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

