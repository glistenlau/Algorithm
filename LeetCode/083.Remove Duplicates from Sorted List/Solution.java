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

    while (head != null) {
      while (head.next != null && head.val == head.next.val) {
        head.next = head.next.next;
      }
      head = head.next;
    }

    return dummy.next;
  }
}