/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode mid = getmid(head);
    ListNode right = sortList(mid.next);
    mid.next = null;
    ListNode left = sortList(head);

    return combine(left, right);
  }

  private ListNode getmid(ListNode head) {
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }

    return slow;
  }

  private ListNode combine(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        ListNode temp = left.next;
        left.next = null;
        tail.next = left;
        left = temp;
      } else {
        ListNode temp = right.next;
        right.next = null;
        tail.next = right;
        right = temp;
      }
      tail = tail.next;
    }

    if (left != null) {
      tail.next = left;
    }
    if (right != null) {
      tail.next = right;
    }
    return dummy.next;
  }
}