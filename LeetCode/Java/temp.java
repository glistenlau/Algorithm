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

  public static void main(String[] args) {
    ListNode test = new ListNode(Integer.MIN_VALUE).serilization("21->25->25->31->4");
    ListNode result = new temp().sortList(test);
    return;
  }
}

