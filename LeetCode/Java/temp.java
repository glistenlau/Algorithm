import java.util.*;

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
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode pre = dummy;

    while (pre != null && head != null) {
      ListNode end = pre;
      ListNode aft = head;
      int count = k;
      while(count > 0 && end != null && aft != null) {
        end = end.next;
        aft = aft.next;
        count--;
      }
      if (count != 0) {
        break;
      }
      end.next = null;
      pre.next = reverse(head);
      head.next = aft;
      pre = head;
      head = aft;
    }
    return dummy.next;
  }

  private ListNode reverse(ListNode head) {
    ListNode dummy = new ListNode(0);
    while(head != null) {
      ListNode temp = head.next;
      head.next = dummy.next;
      dummy.next = head;
      head = temp;
    }
    return dummy.next;
  }





  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {-1,-2,-3,-100,-1,-50};

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    ListNode result = new temp().reverseKGroup(head, 2);
    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

