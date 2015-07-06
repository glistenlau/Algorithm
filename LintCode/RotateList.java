/**
 * Rotate List
 * http://www.lintcode.com/en/problem/rotate-list/
 *
 * Given a list, rotate the list to the right by k places, where k is
 * non-negtive.
 *
 * Example
 * Given 1->2->3->4->5, and k = 2, return 4->5->1->2->3.
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
   * @param head: the List
   * @param k: rotate to the right k places
   * @return: the list after rotation
   */
  public ListNode rotateRight(ListNode head, int k) {
    // write your code here
    if (head == null) {
      return null;
    }
    int len = getLength(head);
    k = k % len;
    if (k == 0) {
      return head;
    }
    ListNode curt = head;
    for (int i = 0; i < k; i++) {
      curt = curt.next;
    }
    ListNode pre = head;
    while (curt.next != null) {
      curt = curt.next;
      pre = pre.next;
    }
    ListNode temp = pre.next;
    pre.next = null;
    curt.next = head;
    return temp;
  }

  private int getLength(ListNode head) {
    int count = 0;
    while (head != null) {
      count += 1;
      head = head.next;
    }
    return count;
  }
}
