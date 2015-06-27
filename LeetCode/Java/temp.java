import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class temp {
  /**
   * @param root:  The root of the binary search tree.
   * @param value: Remove the node with given value.
   * @return: The root of the binary search tree after removal.
   */
  public TreeNode removeNode(TreeNode root, int value) {
    // write your code here
    if (root == null) {
      return null;
    }

    if (root.val == value) {
      if (root.left != null && root.right != null) {
        TreeNode swap = findMax(root.left);
        if (swap.left != null) {
          swap.left = removeNode(root.left, swap.val);
          swap.right = root.right;
        } else {
          swap.left = removeNode(root.left, swap.val);
          swap.right = root.right;
        }
        return swap;
      } else if (root.left != null) {
        return root.left;
      } else if (root.right != null) {
        return root.right;
      } else {
        return null;
      }
    }

    root.left = removeNode(root.left, value);
    root.right = removeNode(root.right, value);

    return root;
  }

  private TreeNode findMax(TreeNode root) {
    if (root == null || root.right == null) {
      return root;
    }

    return findMax(root.right);
  }

  public static void main(String[] args) {
    TreeNode test = new BinaryTreeSerialization().deserialize("20,1,40,#,#,35");
    TreeNode result = new temp().removeNode(test, 20);
    return;
  }

}