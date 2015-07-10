/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  /**
   * @param hashTable: A list of The first node of linked list
   * @return: A list of The first node of linked list which have twice size
   */
  public ListNode[] rehashing(ListNode[] hashTable) {
    if (hashTable == null || hashTable.length == 0) {
      return null;
    }
    int oriSize = hashTable.length;
    int rehSize = oriSize * 2;
    ListNode[] result = new ListNode[rehSize];

    for (int i = 0; i < oriSize; i++) {
      if (hashTable[i] == null) {
        continue;
      } else {
        ListNode dummy = new ListNode(0);
        dummy.next = hashTable[i];
        ListNode temp = dummy.next;
        while (temp != null) {
          ListNode tmp = temp.next;
          int index = (temp.val % rehSize + rehSize) % rehSize;
          if (result[index] == null) {
            result[index] = temp;
            temp.next = null;
          } else {
            ListNode curt = result[index];
            while (curt != null && curt.next != null) {
              curt = curt.next;
            }
            curt.next = temp;
            temp.next = null;
          }
          temp = tmp;
        }
      }
    }
    return result;
  }
};

