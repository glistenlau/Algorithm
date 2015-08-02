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
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    boolean normalDirection = true;
    Stack<TreeNode> leftRight = new Stack<TreeNode>();
    Stack<TreeNode> rightLeft = new Stack<TreeNode>();

    if (root != null) {
      leftRight.push(root);
    }

    while(!leftRight.isEmpty() || !rightLeft.isEmpty()) {
      List<Integer> temp = new ArrayList<Integer>();
      int size = normalDirection? leftRight.size(): rightLeft.size();

      for (int i = 0; i < size; i++) {
        TreeNode curt = normalDirection? leftRight.pop(): rightLeft.pop();
        temp.add(curt.val);
        if (!normalDirection) {
          if (curt.right != null) {
            leftRight.push(curt.right);
          }
          if (curt.left != null) {
            leftRight.push(curt.left);
          }
        } else {
          if (curt.left != null) {
            rightLeft.push(curt.left);
          }
          if (curt.right != null) {
            rightLeft.push(curt.right);
          }
        }
      }

      normalDirection ^= true;
      result.add(temp);
    }

    return result;
  }
}