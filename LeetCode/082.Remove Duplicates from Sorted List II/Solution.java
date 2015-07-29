/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode pre = dummy;

    while (head != null) {
      while (head.next != null && head.val == head.next.val) {
        head = head.next;
      }

      if (pre.next != head) {
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