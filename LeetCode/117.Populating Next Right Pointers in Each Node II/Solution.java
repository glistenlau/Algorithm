/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void connect(TreeLinkNode root) {
    TreeLinkNode curt = root;
    while(curt != null) {
      TreeLinkNode next = null;
      while(next == null && curt != null) {
        if (curt.left != null) {
          next = curt.left;
        } else if (curt.right != null) {
          next = curt.right;
        } else {
          curt = curt.next;
        }
      }

      TreeLinkNode prev = next;
      while (curt != null && next != null) {
        if (curt.left != null && curt.left != prev) {
          prev.next = curt.left;
          prev = curt.left;
        }
        if (curt.right != null && curt.right != prev) {
          prev.next = curt.right;
          prev = curt.right;
        }
        curt = curt.next;
      }

      curt = next;
    }
  }
}