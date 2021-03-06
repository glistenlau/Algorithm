/**
 * Linked List Cycle
 * http://www.lintcode.com/en/problem/linked-list-cycle/
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Example
 * Given -21->10->4->5, tail connects to node index 1, return true.
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
   * @return: True if it has a cycle, or false
   */
  public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null) {
      if (fast == slow) {
        return true;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return false;
  }

}

