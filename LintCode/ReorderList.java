/**
 * Reorder List
 * http://www.lintcode.com/en/problem/reorder-list/
 *
 * Given a singly linked list L: L0->L1->...->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->...
 *
 * You must do the in-place without altering the nodes' values.
 *
 * Example
 * For example,
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 */

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class Solution {
  /**
   * @param head: The head of linked list.
   * @return: void
   */
  public void reorderList(ListNode head) {
    if (head == null || head.next == null) {
      return;
    }
    ListNode lastHalf = head;
    int size = 0;
    while (lastHalf != null) {
      size += 1;
      lastHalf = lastHalf.next;
    }
    lastHalf = head;
    for (int i = 0; i < (size + 1) / 2; i++) {
      lastHalf = lastHalf.next;
    }
    lastHalf = reverse(lastHalf);
    ListNode firstHalf = head;
    while (lastHalf != null) {
      ListNode temp = firstHalf.next;
      firstHalf.next = lastHalf;
      lastHalf = lastHalf.next;
      firstHalf.next.next = temp;
      firstHalf = temp;
    }
    firstHalf.next = null;
  }

  private ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    ListNode pre = dummy;
    while (head != null) {
      ListNode temp = head.next;
      head.next = pre.next;
      pre.next = head;
      head = temp;
    }
    return dummy.next;
  }
}

