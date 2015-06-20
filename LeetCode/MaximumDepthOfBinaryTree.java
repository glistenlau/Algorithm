/**
 * Created by YiLIU on 6/20/15.
 */
public class MaximumDepthOfBinaryTree {
  public int maxDepth(TreeNode root) {
    // write your code here
    if (root == null) {
      return 0;
    }

    int maxLeft = 0;
    int maxRight = 0;

    if (root.left != null) {
      maxLeft = maxDepth(root.left);
    }
    if (root.right != null) {
      maxRight = maxDepth(root.right);
    }

    return Math.max(maxLeft, maxRight) + 1;
  }
}
