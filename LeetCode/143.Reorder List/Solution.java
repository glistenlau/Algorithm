/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }

    ListNode fast = head.next;
    ListNode slow = head;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    fast = reverseList(slow.next);
    slow.next = null;
    slow = head;

    while (slow != null && fast != null) {
      ListNode temp = fast.next;
      fast.next = slow.next;
      slow.next = fast;
      fast = temp;
      slow = slow.next.next;
    }

  }

  private ListNode reverseList(ListNode head) {
    ListNode reversed = null;
    while (head != null) {
      ListNode temp = head.next;
      head.next = reversed;
      reversed = head;
      head = temp;
    }
    return reversed;
  }
}