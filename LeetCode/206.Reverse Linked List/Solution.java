/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Solution 1: Interation
public class Solution {
  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

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

// Solution 2: Recursion
public class Solution {
  public ListNode reverseList(ListNode head) {
    return reverseList(head, null);
  }

  private ListNode reverseList(ListNode head, ListNode pre) {
    if (head == null) {
      return pre;
    }

    ListNode next = head.next;
    head.next = pre;

    return reverseList(next, head);
  }
}