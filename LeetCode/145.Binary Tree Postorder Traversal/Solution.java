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
  public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    TreeNode pre = null;
    TreeNode curt = root;
    stack.push(root);
    while (!stack.isEmpty()) {
      curt = stack.peek();
      if (pre == null || pre.left == curt || pre.right == curt) {
        if (curt.left != null) {
          stack.push(curt.left);
        } else if (curt.right != null){
          stack.push(curt.right);
        }
      } else if (curt.left == pre) {
        if (curt.right != null) {
          stack.push(curt.right);
        }
      } else {
        result.add(stack.pop().val);
      }
      pre = curt;
    }

    return result;
  }
}