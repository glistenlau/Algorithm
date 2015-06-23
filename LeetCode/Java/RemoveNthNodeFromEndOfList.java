/**
 * Created by YiLIU on 6/16/15.
 */
public class RemoveNthNodeFromEndOfList {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode copy = head;
    int count = 0;
    while (copy != null) {
      ++count;
      copy = copy.next;
    }
    if (count - n - 1 < 0) {
      head = head.next;
      return head;
    }
    copy = head;
    for (int i = 0; i < count - n - 1; ++i) {
      copy = copy.next;
    }
    if (copy.next != null) {
      copy.next = copy.next.next;
    }
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
//    ListNode test = new RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 2);
    ListNode test = new RemoveNthNodeFromEndOfList().removeNthFromEnd(new
        ListNode(1), 1);
    while (test != null) {
      System.out.println(test.val);
      test = test.next;
    }
  }
}
