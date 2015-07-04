/**
 * Remove Nth Node From End of List
 * http://www.lintcode.com/en/problem/remove-nth-node-from-end-of-list/
 *
 * Given a linked list, remove the nth node form the end of list and return
 * its head.
 *
 * Example
 * Given linked list 1->2->3->4->5->null, and n = 2.
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5->null.
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
   * @param head: The first node of linked list.
   * @param n: An integer.
   * @return: The head of linked list.
   */
  ListNode removeNthFromEnd(ListNode head, int n) {
    // write your code here
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = dummy;
    for (int i = 0; i < n; i++) {
      fast = fast.next;
      if (fast == null) {
        return null;
      }
    }
    ListNode slow = dummy;
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    ListNode temp = slow.next != null ? slow.next.next : null;
    slow.next = temp;
    return dummy.next;
  }
}

