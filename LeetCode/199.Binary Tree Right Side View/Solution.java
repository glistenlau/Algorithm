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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> ans = new ArrayList<Integer>();
    if (root == null) {
      return ans;
    }

    Queue<TreeNode> myQ = new LinkedList<>();
    myQ.offer(root);
    while (!myQ.isEmpty()) {
      int size = myQ.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = myQ.poll();
        if (i == 0) {
          ans.add(cur.val);
        }

        if (cur.right != null) {
          myQ.offer(cur.right);
        }
        if (cur.left != null) {
          myQ.offer(cur.left);
        }
      }
    }

    return ans;
  }
}