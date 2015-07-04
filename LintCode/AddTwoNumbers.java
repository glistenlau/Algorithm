/**
 * Add Two Numbers
 * http://www.lintcode.com/en/problem/add-two-numbers/
 *
 * You have two numbers represented by linked list, where each node contains
 * a single digit. The digits are sorted in reverse order, such that the 1's
 * digit is at the head of the list. Write a function that adds the two
 * numbers and returns the sum as a linked list.
 *
 * Example
 * Given 7->1->6 + 5->9->2. That is, 617 + 295.
 * Return 2->1->9. That is 912.
 * Given 3->1->5 and 5->9->2, return 8->0->8.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  /**
   * @param l1: the first list
   * @param l2: the second list
   * @return: the sum list of l1 and l2
   */
  public ListNode addLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    int c = 0;
    while (l1 != null && l2 != null) {
      head.next = new ListNode((l1.val + l2.val + c) % 10);
      c = (l1.val + l2.val + c) / 10;
      l1 = l1.next;
      l2 = l2.next;
      head = head.next;
    }
    while (l1 != null) {
      head.next = new ListNode((l1.val + c) % 10);
      c = (l1.val + c) / 10;
      l1 = l1.next;
      head = head.next;
    }
    while (l2 != null) {
      head.next = new ListNode((l2.val + c) % 10);
      c = (l2.val + c) / 10;
      l2 = l2.next;
      head = head.next;
    }
    if (c != 0) {
      head.next = new ListNode(c);
    }
    return dummy.next;
  }
}
