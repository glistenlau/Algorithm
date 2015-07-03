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
   * @param head: The head of linked list.
   * @return: The new head of reversed linked list.
   */
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
    nextNode.next = new ListNode(head.val);
    return pre;
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(0);
    test.next = new ListNode(1);
    test.next.next = new ListNode(2);
    new temp().reverse(test);
  }
}

