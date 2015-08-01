
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
  public boolean isValidBST(TreeNode root) {
    boolean begin = false;
    int pre = Integer.MIN_VALUE;
    Stack<TreeNode> myStack = new Stack<TreeNode>();
    TreeNode curt = root;
    while(!myStack.isEmpty() || curt != null) {
      while(curt != null) {
        myStack.push(curt);
        curt = curt.left;
      }

      curt = myStack.pop();

      if (begin && curt.val <= pre) {
        return false;
      }
      begin = true;
      pre = curt.val;
      curt = curt.right;
    }
    return true;
  }
}