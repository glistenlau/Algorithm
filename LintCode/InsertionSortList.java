/**
 * Insertion Sort List
 * http://www.lintcode.com/en/problem/insertion-sort-list/
 *
 * Sort a linked list using insertion sort.
 *
 * Example
 * Given 1->3->2->0->null, return 0->1->2->3->null.
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
   * @param head: The first node of linked list.
   * @return: The head of linked list.
   */
  public ListNode insertionSortList(ListNode head) {
    ListNode dummy = new ListNode(Integer.MAX_VALUE);
    while (head != null) {
      ListNode cur = dummy;
      while (cur.next != null && cur.next.val < head.val) {
        cur = cur.next;
      }
      ListNode temp = head.next;
      head.next = cur.next;
      cur.next = head;
      head = temp;
    }
    return dummy.next;
  }

  private ListNode binarySearch(ListNode head, ListNode target) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    if (slow.val < target.val) {
      return binarySearch(slow, target);
    } else {
      slow.next = null;
      slow = null;
      return binarySearch(head, target);
    }
  }
}