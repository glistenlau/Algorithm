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
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }
    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode curt = stack.pop();
      result.add(curt.val);
      if (curt.right != null) {
        stack.push(curt.right);
      }
      if (curt.left != null) {
        stack.push(curt.left);
      }
    }
    return result;
  }
}