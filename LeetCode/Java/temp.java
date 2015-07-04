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
public class temp {
  /**
   * @param head: The head of linked list
   */
  private ListNode binarySearch(ListNode head, ListNode target) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      head = head.next;
    }
    if (head.next.val < target.val) {
      return binarySearch(head.next, target);
    } else {
      head.next = null;
      return binarySearch(dummy.next, target);
    }
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(Integer.MIN_VALUE);
    test.next = new ListNode(-1);
    test.next.next = new ListNode(1);
    ListNode result = new temp().binarySearch(test, new ListNode(-2));
    return;
  }
}

