/**
 * Unique Binary Search Trees II
 * www.lintcode.com/en/problem/unique-binary-search-trees-ii/
 *
 * Given n, generate all structurally unique BST's that store values 1...n.
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
public class Solution {
  /**
   * @paramn n: An integer
   * @return: A list of root
   */
  public List<TreeNode> generateTrees(int n) {
    // write your code here
    List<TreeNode> ans = new ArrayList<>();
    if (n == 0) {
      ans.add(null);
      return ans;
    }

    return generateTrees(1, n);
  }

  private List<TreeNode> generateTrees(int start, int end) {
    if (start > end) {
      return new ArrayList<>();
    }

    List<TreeNode> ans = new ArrayList<>();
    for (int i = start; i <= end ; i++) {
      List<TreeNode> left = generateTrees(start, i - 1);
      List<TreeNode> right = generateTrees(i + 1, end);
      if (left.size() == 0) {
        left.add(null);
      }
      if (right.size() == 0) {
        right.add(null);
      }
      for (TreeNode l: left) {
        for (TreeNode r: right) {
          TreeNode root = new TreeNode(i);
          root.left = l;
          root.right = r;
          ans.add(root);
        }
      }
    }


    return ans;
  }
}
