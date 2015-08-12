/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
      return null;
    }

    HashMap<RandomListNode, RandomListNode> copyMap = new HashMap<>();
    RandomListNode curt = head;
    while (curt != null) {
      copyMap.put(curt, new RandomListNode(curt.label));
      curt = curt.next;
    }

    curt = head;
    while (curt != null) {
      RandomListNode curtCopy = copyMap.get(curt);
      curtCopy.next = copyMap.get(curt.next);
      curtCopy.random = copyMap.get(curt.random);
      curt = curt.next;
    }

    return copyMap.get(head);
  }
}