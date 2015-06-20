/**
 * Created by yi on 5/5/15.
 */
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return max;
    }

    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        int leftBranch = pathSum(root.left);
        int rightBranch = pathSum(root.right);
        int sumNode = 0;
        sumNode = leftBranch + root.val > root.val ? leftBranch + root.val : root.val;
        sumNode = rightBranch + root.val > root.val ? rightBranch + sumNode : sumNode;
        max = sumNode > max ? sumNode : max;
        int maxBranch = Math.max(leftBranch, rightBranch);
        return root.val + maxBranch > root.val ? root.val + maxBranch : root.val;
    }
}
