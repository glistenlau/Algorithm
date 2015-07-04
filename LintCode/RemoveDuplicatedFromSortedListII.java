/**
 * Remove Duplicates from Sorted List II
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-list-ii/
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers form the original list.
 *
 * Example
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
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
   * @return: ListNode head of the linked list
   */
  public static ListNode deleteDuplicates(ListNode head) {
    // write your code here
    ListNode dummy = new ListNode(0);
    ListNode preD = null;
    ListNode cur = dummy;
    while (head != null) {
      if (preD != null && head.val == preD.val) {
        head = head.next;
      } else if (head.next != null && head.val == head.next.val) {
        preD = head;
        head = head.next.next;
      } else {
        cur.next = head;
        cur = cur.next;
        head = head.next;
      }
    }
    cur.next = null;
    return dummy.next;
  }
}

