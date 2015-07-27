/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null) {
      return null;
    }
    int num = 0;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = dummy;
    ListNode fast = dummy;

    while (fast.next != null) {
      fast = fast.next;
      num++;
    }

    k = k % num;
    if (k == 0) {
      return head;
    }
    fast = dummy;

    while (k > 0) {
      fast = fast.next;
      k--;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    fast.next = dummy.next;
    dummy.next = slow.next;
    slow.next = null;

    return dummy.next;
  }
}