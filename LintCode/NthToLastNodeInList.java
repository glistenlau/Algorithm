/**
 * Nth to Last Node in List
 * http://www.lintcode.com/en/problem/nth-to-last-node-in-list/
 *
 * Find the nth to the last element to last element of a singly linked list.
 * The minimum number of nodes in list is n.
 *
 * Example
 * Given a List 3->2->1->5->null and n = 2, return node whose value is 1.
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
   * @return: Nth to last node of a singly linked list.
   */
  ListNode nthToLast(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode fast = head;
    for (int i = 0; i < n - 1; i++) {
      if (fast == null) {
        return null;
      }
      fast = fast.next;
    }
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}

