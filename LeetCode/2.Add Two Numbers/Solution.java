/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    int c = 0;
    while(l1 != null && l2 != null) {
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