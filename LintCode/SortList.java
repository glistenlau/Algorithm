/**
 * Sort List
 * http://www.lintcode.com/en/problem/sort-list/
 *
 * Sort a linked list in O(nlogn) time using constant space complexity.
 *
 * Example Given 1->3->2->null, sort it to 1->2->3->null.
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
   * @return: You should return the head of the sorted linked list,
  using constant space complexity.
   */
  // merge sort
  public ListNode sortList(ListNode head) {
    if (head == null) {
      return null;
    }
    int size = 0;
    ListNode curt = head;
    while (curt != null) {
      curt = curt.next;
      size += 1;
    }
    return merge(head, size);
  }

  private ListNode merge(ListNode head, int size) {
    if (size <= 1) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    for (int i = 1; i < (size + 1) / 2; i++) {
      head = head.next;
    }
    ListNode rStart = head.next.next;
    head.next.next = null;
    ListNode left = merge(dummy.next, (size + 1) / 2);
    ListNode right = merge(rStart, size - (size + 1) / 2);

    return combine(left, right);
  }

  private ListNode combine(ListNode left, ListNode right) {
    ListNode dummy = new ListNode(0);
    ListNode head = dummy;
    while (left != null && right != null) {
      if (left.val < right.val) {
        head.next = new ListNode(left.val);
        left = left.next;
        head = head.next;
      } else {
        head.next = new ListNode(right.val);
        right = right.next;
        head = head.next;
      }
    }
    if (left != null) {
      head.next = left;
    }
    if (right != null) {
      head.next = right;
    }
    return dummy.next;
  }
}

// quick sortpublic

  ListNode sortList(ListNode head) {

    if (head == null) {
      return null;
    }
    return quickSort(head);
  }

  private ListNode quickSort(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    ListNode mid = findMid(head);
    ListNode right = mid.next;
    ListNode lessDummy = new ListNode(0), less = lessDummy;
    ListNode moreDummy = new ListNode(0), more = moreDummy;
    ListNode equalDummy = new ListNode(0), equal = equalDummy;

    while (head != mid.next) {
      if (head.val < mid.val) {
        less.next = head;
        less = less.next;
      } else if (head.val > mid.val) {
        more.next = head;
        more = more.next;
      } else {
        equal.next = head;
        equal = equal.next;
      }
      head = head.next;
    }
    while (right != null) {
      if (right.val < mid.val) {
        less.next = right;
        less = less.next;
      } else if (right.val > mid.val) {
        more.next = right;
        more = more.next;
      } else {
        equal.next = right;
        equal = equal.next;
      }
      right = right.next;
    }

    less.next = null;
    more.next = null;
    equal.next = null;

    ListNode first = quickSort(lessDummy.next);
    ListNode last = quickSort(moreDummy.next);
    if (first != null){
      dummy.next = first;
      while(first != null && first.next != null) {
        first = first.next;
      }
      first.next = equalDummy.next;
    } else {
      dummy.next = equalDummy.next;
    }
    equal.next = last;
    return dummy.next;
  }

  private ListNode findMid(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode fast = head.next;
    ListNode slow = head;
    while(fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }

