/**
 * Numbers keep coming, return the median of numbers at every time a new
 * number added.
 *
 * Example
 * For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3].
 * For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3].
 * For numbers coming list: [2, 20, 100], return [2, 2, 20].
 */

public class Solution {
  /**
   * @param nums: A list of integers.
   * @return: the median of numbers
   */
  public int[] medianII(int[] nums) {
    // write your code here
    int[] result = new int[nums.length];
    if (nums == null || nums.length == 0) {
      return result;
    }

    Queue<Integer> minQ = new PriorityQueue<Integer>();
    Queue<Integer> maxQ = new PriorityQueue<Integer>((nums.length / 2) + 1, maxQueueCom);
    int mid = nums[0];
    result[0] = mid;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] < mid) {
        maxQ.offer(nums[i]);
      } else {
        minQ.offer(nums[i]);
      }
      if (minQ.size() - maxQ.size() > 1) {
        maxQ.offer(mid);
        mid = minQ.poll();
      }
      if (maxQ.size() - minQ.size() > 0) {
        minQ.offer(mid);
        mid = maxQ.poll();
      }
      result[i] = mid;
    }
    return result;
  }

  private Comparator<Integer> maxQueueCom = new Comparator<Integer>() {
    @Override
    public int compare(Integer n1, Integer n2) {
      return n2 - n1;
    }
  };
}
