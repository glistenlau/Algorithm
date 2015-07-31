/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode preLess = new ListNode(0);
    ListNode preMore = new ListNode(0);
    ListNode less = preLess;
    ListNode more = preMore;

    while (head != null) {
      if (head.val < x) {
        less.next = head;
        less = less.next;
      } else {
        more.next = head;
        more = more.next;
      }
      head = head.next;
    }
    less.next = preMore.next;
    more.next = null;

    return preLess.next;
  }
}