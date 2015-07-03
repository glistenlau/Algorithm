/**
 * Remove Duplicates form Sorted List
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list/
 *
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 *
 * Example
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */

/**
 * Definition for ListNode
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
   * @param ListNode head is the head of the linked list
   * @return: ListNode head of linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    // write your code here
    ListNode dummy = new ListNode(Integer.MAX_VALUE);
    dummy.next = head;
    ListNode pre = null;
    while (head != null) {
      if (pre != null && head.val == pre.val) {
        pre.next = head.next;
        head = head.next;
      } else {
        pre = head;
        head = head.next;
      }
    }
    return dummy.next;
  }
}
