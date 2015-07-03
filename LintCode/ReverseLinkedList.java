/**
 * Reverse Linked List
 * http://www.lintcode.com/en/problem/reverse-linked-list/
 *
 * Example
 * For linked list 1->2->3, the reversed linked list is 3->2->1
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
   * @return: The new head of reversed linked list.
   */
  public ListNode reverse(ListNode head) {
    // write your code here
    ListNode cur = new ListNode(0);
    while (head != null) {
      ListNode temp = head.next;
      head.next = cur.next;
      cur.next = head;
      head = temp;
    }
    return cur.next;
  }

  // Recursion
  public ListNode reverse(ListNode head) {
    // write your code here
    if (head == null) {
      return null;
    }
    if (head.next == null) {
      return head;
    }
    ListNode nextNode = head.next;
    ListNode pre = reverse(nextNode);
    head.next = null;
    nextNode.next = head;
    return pre;
  }
}