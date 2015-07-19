import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// Solution1: merge every two sorted lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    Queue<ListNode> myQueue = new LinkedList<ListNode>();

    for (ListNode head : lists) {
      if (head != null) {
        myQueue.offer(head);
      }
    }

    while (myQueue.size() > 1) {
      ListNode l1 = myQueue.poll();
      ListNode l2 = myQueue.poll();
      ListNode comb = sortLists(l1, l2);
      myQueue.offer(comb);
    }
    return myQueue.poll();
  }

  private ListNode sortLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode dummy = new ListNode(0);

    ListNode curt = dummy;
    while(l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curt.next = l1;
        l1 = l1.next;
      } else {
        curt.next = l2;
        l2 = l2.next;
      }
      curt = curt.next;
    }
    if (l1 != null) {
      curt.next = l1;
    }
    if (l2 != null) {
      curt.next = l2;
    }
    return dummy.next;
  }
}

// Solution 2: Use PriorityQueue
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }

    Queue<ListNode> myQueue = new PriorityQueue<ListNode>(lists.length,
        listComparator);

    for (ListNode l : lists) {
      if (l != null) {
        myQueue.offer(l);
      }
    }
    ListNode dummy = new ListNode(0);
    ListNode curt = dummy;
    while(!myQueue.isEmpty()) {
      ListNode temp = myQueue.poll();
      curt.next = temp;
      curt = curt.next;
      if (temp.next != null) {
        myQueue.offer(temp.next);
      }
    }
    return dummy.next;
  }

  private Comparator<ListNode> listComparator = new Comparator<ListNode>() {
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
