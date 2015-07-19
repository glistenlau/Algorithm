/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;

    while (pre != null && head != null) {
      ListNode end = pre;
      ListNode aft = head;
      int count = k;
      while(count > 0 && end != null && aft != null) {
        end = end.next;
        aft = aft.next;
        count--;
      }
      if (count != 0) {
        break;
      }
      end.next = null;
      pre.next = reverse(head);
      head.next = aft;
      pre = head;
      head = aft;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    while(head != null) {
      ListNode temp = head.next;
      head.next = dummy.next;
      dummy.next = head;
      head = temp;
    }
    return dummy.next;
  }
}