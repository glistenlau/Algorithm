/**
 * Merge k Sorted Lists
 * http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 *
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 *
 * Example
 * Given lists:
 * [
 *   2->4->null,
 *   null,
 *   -1->null
 * ]
 * return -1->2->4->null.
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
   * @param lists: a list of ListNode
   * @return: The head of one sorted list.
   */
  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }
    while(lists.size() > 1) {
      ListNode first = lists.get(0);
      ListNode second = lists.get(1);
      ListNode merged = merge(first, second);
      lists.remove(0);
      lists.remove(0);
      lists.add(merged);
    }
    return lists.get(0);
  }

  private ListNode merge(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode curt = dummy;
    while(left != null && right != null) {
      if (left.val < right.val) {
        curt.next = left;
        left = left.next;
      } else {
        curt.next = right;
        right = right.next;
      }
      curt = curt.next;
    }
    if (left != null) {
      curt.next = left;
    }
    if (right != null) {
      curt.next = right;
    }
    return dummy.next;
  }

  // use heap
  public ListNode mergeKLists(List<ListNode> lists) {
    if (lists == null || lists.size() == 0) {
      return null;
    }
    Queue<ListNode> myQueue = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
    for (int i = 0; i < lists.size(); i++) {
      if (lists.get(i) != null) {
        myQueue.offer(lists.get(i));
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode curt = dummy;
    while (!myQueue.isEmpty()) {
      curt.next = myQueue.poll();
      curt = curt.next;
      if (curt.next != null) {
        myQueue.offer(curt.next);
      }
    }
    return dummy.next;
  }

  private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
    public int compare(ListNode l1, ListNode l2) {
      if (l1 == null) {
        return 1;
      }
      if (l2 == null) {
        return -1;
      }
      return l1.val - l2.val;
    }
  };
}

