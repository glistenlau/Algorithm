/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != null && b != null) {
      a = a.next;
      b = b.next;
    }
    ListNode A = headA;
    ListNode B = headB;
    while (a != null) {
      a = a.next;
      A = A.next;
    }
    while (b != null) {
      b = b.next;
      B = B.next;
    }
    while (A != null && B != null) {
      if (A == B) {
        return A;
      }
      A = A.next;
      B = B.next;
    }

    return null;
  }
}