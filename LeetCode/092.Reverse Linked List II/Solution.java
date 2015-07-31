/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode start = head;
    ListNode pre = dummy;

    for (int i = 0; i < m - 1; i++) {
      pre = pre.next;
      start = start.next;
    }

    for (int i = 0; i < n - m; i++) {
      ListNode temp = start.next.next;
      start.next.next = pre.next;
      pre.next = start.next;
      start.next = temp;
    }

    return dummy.next;
  }
}