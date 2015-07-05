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
  public ListNode reverseBetween(ListNode head, int m, int n) {
    // write your code here
    if (m >= n || head == null) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    head = dummy;
    for (int i = 1; i < m; i++) {
      head = head.next;
      if (head == null) {
        return null;
      }
    }
    ListNode preM = head;
    ListNode mNode = head.next;
    ListNode nNode = mNode, postnNode = mNode.next;
    for (int i = m; i < n; i++) {
      if (postnNode == null) {
        return null;
      }
      ListNode temp = postnNode.next;
      postnNode.next = nNode;
      nNode = postnNode;
      postnNode = temp;
    }
    mNode.next = postnNode;
    preM.next = nNode;
    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode test = new ListNode(Integer.MIN_VALUE).serilization("3760->2881->7595->3904->5069->4421->8560->8879->8488->5040->5792->56->1007->2270->3403->6062");
    ListNode result = new temp().reverseBetween(test, 2, 7);
    return;
  }
}

