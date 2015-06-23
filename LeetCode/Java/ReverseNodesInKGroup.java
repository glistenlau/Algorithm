/**
 * Created by YiLIU on 6/17/15.
 */
public class ReverseNodesInKGroup {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k <= 1) {
      return head;
    }
    ListNode cur = head;
    int length = 0;
    while (cur != null) {
      cur = cur.next;
      length++;
    }
    int multi = length / k;
    if (multi == 0) return head;
    ListNode preTail = null, curHead = null, curTail = null;
    ListNode preNode = null, nextNode = null;
    cur = head;
    for (int i = 0; i < multi; ++i) {
      preNode = null;
      for (int j = 0; j < k; ++j) {
        if (cur != null) {
          nextNode = cur.next;
          cur.next = preNode;
          preNode = cur;
        }
        if (j == 0) curTail = cur;
        if (j == k - 1) curHead = cur;
        cur = nextNode;
      }
      if (preTail == null) head = curHead;
      else preTail.next = curHead;
      preTail = curTail;
    }
    curTail.next = cur;
    return head;
  }

  public static void main(String[] args) {
    ListNode l = new ListNode(1);
    l.next = new ListNode(2);
    l.next.next = new ListNode(3);
    l.next.next.next = new ListNode(4);
    l.next.next.next.next = new ListNode(5);
    ListNode test = new ReverseNodesInKGroup().reverseKGroup(l.next.next
        .next, 2);
    while (test != null) {
      System.out.println(test.val);
      test = test.next;
    }
  }

}
