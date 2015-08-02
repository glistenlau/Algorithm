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
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
    myQueue.offer(root);
    while(!myQueue.isEmpty()) {
      int size = myQueue.size();
      List<Integer> level = new ArrayList<Integer>();
      for (int i = 0; i < size; i++) {
        TreeNode curt = myQueue.poll();
        level.add(curt.val);
        if (curt.left != null) {
          myQueue.offer(curt.left);
        }
        if (curt.right != null) {
          myQueue.offer(curt.right);
        }
      }
      result.add(level);
    }
    Collections.reverse(result);
    return result;
  }
}