/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    slow.next = reverse(slow.next);
    ListNode latter = slow.next;
    ListNode first = head;

    while (latter != null) {
      if (first.val != latter.val) {
        return false;
      }
      latter = latter.next;
      first = first.next;
    }

    return true;
  }

  private ListNode reverse(ListNode head) {
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