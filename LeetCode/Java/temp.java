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
  /**
   * @param head: The head of linked list
   */
  public int[] medianII(int[] nums) {
    // write your code here
    int[] result = new int[nums.length];
    if (nums == null || nums.length == 0) {
      return result;
    }

    Queue<Integer> minQ = new PriorityQueue<Integer>();
    Queue<Integer> maxQ = new PriorityQueue<Integer>(maxQueueCom);
    int mid = nums[0];
    result[0] = mid;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < mid) {
        minQ.offer(nums[i]);
      } else {
        maxQ.offer(nums[i]);
      }
      if (minQ.size() - maxQ.size() > 0) {
        maxQ.offer(mid);
        mid = minQ.poll();
      }
      if (maxQ.size() - minQ.size() > 1) {
        minQ.offer(mid);
        mid = maxQ.poll();
      }
      result[i] = mid;
    }
    return result;
  }

  public Comparator<Integer> maxQueueCom = (o1, o2) -> o2 - o1;





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
    int[] A = {1, 2, 3, 4, 5};
    int[] result = new temp().medianII(A);
    System.out.println(result);
  }
}

