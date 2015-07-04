/**
 * Partition List
 * http://www.lintcode.com/en/problem/partition-list/
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of
 * the two partitions.
 *
 * Exxample
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
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
   * @param x: an integer
   * @return: a ListNode
   */
  public ListNode partition(ListNode head, int x) {
    // write your code here
    ListNode lessDummy = new ListNode(0);
    ListNode moreDummy = new ListNode(0);
    ListNode less = lessDummy;
    ListNode more = moreDummy;

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
    less.next = moreDummy.next;
    more.next = null;
    return lessDummy.next;
  }
}

