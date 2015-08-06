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
    while (curt != null) {
      TreeLinkNode next = curt.left;
      while (next != null && curt != null) {
        curt.left.next = curt.right;
        if (curt.next != null) {
          curt.right.next = curt.next.left;
        }
        curt = curt.next;
      }
      curt = next;
    }
  }
}