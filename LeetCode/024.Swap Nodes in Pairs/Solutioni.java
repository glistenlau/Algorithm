/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curt = dummy;


    while (curt != null && curt.next != null && curt.next.next != null) {
      ListNode temp = curt.next.next.next;
      curt.next.next.next = curt.next;
      curt.next = curt.next.next;
      curt.next.next.next = temp;
      curt = curt.next.next;
    }
    return dummy.next;
  }
}