/**
 * Delete Node in the Middle of Singly Linked List
 * www.lintcode.com/en/problem/delete-node-in-the-middle-of-singly-linked-list/
 *
 * Implement an algorithm to delete a node in the middle of a singly linked list,
 * given only access to that node.
 *
 * Example
 * Given 1->2->3->4, and node 3, return 1->2->4.
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
 */
public class Solution {
  /**
   * @param node: the node in the list should be deleted
   * @return: nothing
   */
  public void deleteNode(ListNode node) {
    // write your code here
    if (node == null) {
      return;
    }

    ListNode cur = node;
    while (cur != null && cur.next != null) {
      cur.val = cur.next.val;
      if (cur.next.next == null) {
        cur.next = null;
      } else {
        cur = cur.next;
      }
    }
  }
}
