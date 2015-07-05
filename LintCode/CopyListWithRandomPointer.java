/**
 * Copy List with Random Pointer
 * http://www.lintcode.com/en/problem/copy-list-with-random-pointer/
 *
 * A Linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  /**
   * @param head: The head of linked list with a random pointer.
   * @return: A new head of a deep copy of the list.
   */
  public RandomListNode copyRandomList(RandomListNode head) {
    // write your code here
    if (head == null) {
      return null;
    }
    RandomListNode curt = head;
    HashMap<RandomListNode, RandomListNode> lookup = new HashMap<RandomListNode, RandomListNode>();
    while(curt != null) {
      lookup.put(curt, new RandomListNode(curt.label));
      curt = curt.next;
    }
    curt = head;
    while(curt != null) {
      lookup.get(curt).next = lookup.get(curt.next);
      lookup.get(curt).random = lookup.get(curt.random);
      curt = curt.next;
    }
    return lookup.get(head);
  }

  // solution use O(1) space.
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }
    //copy every node
    RandomListNode curt = head;
    while (curt != null) {
      RandomListNode temp = curt.next;
      curt.next = new RandomeListNode(curt.label);
      curt.next.next = temp;
      curt = temp;
    }
    //link the random nodes
    curt = head;
    while(curt != null) {
      curt.next.random = curt.random.next;
      curt = curt.next.next;
    }
    RandomListNode dummy = new RandomListNode(0);
    dummy.next = head.next;
    curt = head;
    while (curt != null && curt.next.next != null) {
      RandomListNode temp = curt.next.next;
      curt.next.next = curt.next.next.next;
      curt.next = temp;
      curt = curt.next;
    }
    curt.next.next = null;
    curt.next = null;
    return dummy.next;
  }

}
