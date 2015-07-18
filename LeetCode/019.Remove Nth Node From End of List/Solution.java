/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy;

    while (first.next != null && n > 0) {
      first = first.next;
      n--;
    }

    if (n != 0) {
      return head;
    }

    ListNode pre = dummy;
    while (first.next != null) {
      first = first.next;
      pre = pre.next;
    }

    pre.next = pre.next.next;
    return dummy.next;
  }
}