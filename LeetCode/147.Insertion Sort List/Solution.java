/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode sorted = new ListNode(0);

    while (head != null) {
      ListNode pos = sorted;
      while(pos.next != null && pos.next.val < head.val) {
        pos = pos.next;
      }

      ListNode temp = head.next;
      head.next = pos.next;
      pos.next = head;
      head = temp;
    }

    return sorted.next;
  }
}