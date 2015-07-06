/**
 * Linked List Cycle II
 * http://www.lintcode.com/en/problem/linked-list-cycle-ii/
 *
 * Given a linked list, return the node where the cycle begins. if there is
 * no cycle, return null.
 *
 * Example
 * Given -21->10->4->5, tailconnects to node index 1, return 10
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
   * @return: The node where the cycle begins.
   *           if there is no cycle, return null
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode inCycle = findCycle(head);
    if (inCycle == null) {
      return null;
    }
    return findFirstNode(head, inCycle);
  }

  private ListNode findCycle(ListNode head) {
    if (head == null || head.next == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head.next;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        return fast;
      }
    }
    return null;
  }

  private ListNode findFirstNode(ListNode head, ListNode inCycle) {
    while (true) {
      ListNode fromHead = head;
      ListNode fromSelf = inCycle;
      while(fromHead.next != inCycle) {
        fromHead = fromHead.next;
      }
      while (fromSelf.next != inCycle) {
        fromSelf = fromSelf.next;
      }
      if (fromHead == fromSelf) {
        if (fromHead == head) {
          return head;
        } else {
          inCycle = fromSelf;
        }
      } else {
        return fromHead.next;
      }
    }
  }
}
