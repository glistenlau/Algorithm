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
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    Queue<TreeNode> myQ = new LinkedList<TreeNode>();
    if (root != null) {
      myQ.offer(root);
    }

    while(!myQ.isEmpty()) {
      List<Integer> temp = new ArrayList<Integer>();
      int size = myQ.size();
      for (int i = 0; i< size; i++) {
        TreeNode curt = myQ.poll();
        temp.add(curt.val);
        if (curt.left != null) {
          myQ.offer(curt.left);
        }
        if (curt.right != null) {
          myQ.offer(curt.right);
        }
      }
      result.add(temp);
    }
    return result;
  }
}