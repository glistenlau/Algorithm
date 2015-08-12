/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode fast = head;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      if (fast == slow) {
        slow = slow.next.next;
        ListNode first = head;
        while (first != slow) {
          first = first.next;
          slow = slow.next;
        }
        return first;
      }
      slow = slow.next;
    }

    return null;
  }
}