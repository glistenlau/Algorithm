/**
 * Convert Sorted List to Binary Search Tree
 * http://www.lintcode.com/en/problem/convert-sorted-list-to-binary-search-tree/
 *
 * Given a singly linked list where elements are sorted in ascending order
 * convert it to height balanced BST.
 *
 * Example
 *               2
 * 1->2->3 =>  /  \
 *            1    3
 */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
  /**
   * @param head: The first node of linked list.
   * @return: a tree node
   */
  public TreeNode sortedListToBST(ListNode head) {
    // write your code here
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return new TreeNode(head.val);
    }
    ListNode fast = head.next;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      head = head.next;
    }
    TreeNode root = new TreeNode(head.next.val);
    root.right = sortedListToBST(head.next.next);
    head.next = null;
    root.left = sortedListToBST(dummy.next);
    return root;
  }
}

