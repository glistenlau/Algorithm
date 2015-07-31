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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    Stack<TreeNode> myStack = new Stack<TreeNode>();
    TreeNode curt = root;

    while(!myStack.isEmpty() || curt != null) {
      while(curt != null) {
        myStack.push(curt);
        curt = curt.left;
      }
      curt = myStack.pop();
      result.add(curt.val);
      curt = curt.right;
    }

    return result;
  }
}