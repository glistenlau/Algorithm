/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode dummy = new ListNode(0);
    ListNode curt = dummy;

    while(l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curt.next = l1;
        l1 = l1.next;
      } else {
        curt.next = l2;
        l2 = l2.next;
      }
      curt = curt.next;
    }

    if (l1 != null) {
      curt.next = l1;
    }
    if (l2 != null) {
      curt.next = l2;
    }

    return dummy.next;
  }
}