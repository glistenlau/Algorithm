/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    dfsHelper(root, sum, new ArrayList<Integer>(), result);
    return result;
  }

  private void dfsHelper(TreeNode root, int sum, List<Integer> taken, List<List<Integer>> result) {
    if (root == null) {
      return;
    }

    taken.add(root.val);
    if (root.val == sum && root.left == null && root.right == null) {
      result.add(new ArrayList<Integer>(taken));
      taken.remove(taken.size() - 1);
      return;
    }

    dfsHelper(root.left, sum - root.val, taken, result);
    dfsHelper(root.right, sum - root.val, taken, result);
    taken.remove(taken.size() - 1);
  }
}