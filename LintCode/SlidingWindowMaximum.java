/**
 * Sliding Window Maximum
 * www.lintcode.com/en/problem/sliding-window-maximum/
 *
 * Given an array of n integer with duplicate number, and a moving window(size k), move the window at each iteration
 * from the start of the array, find the maximum number inside the window at each moving.
 *
 * Example
 * For array [1, 2, 7, 7, 8], moving window size k = 3. return [7, 7, 8].
 * At first the window is at the start of the array like this [|1, 2, 7|, 7, 8], return the maximum 7;
 * then the window move one step forward.
 * [1, |2, 7, 7|, 8], return the maximum 7;
 * then the window move one step forward again.
 * [1, 2, |7, 7, 8|], return the maixum 8;
 */

public class Solution {
  /**
   * @param nums: A list of integers.
   * @return: The maximum number inside the window at each moving.
   */
  public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    // write your code here
    Deque<Integer> myQ = new ArrayDeque<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      while (!myQ.isEmpty() && nums[i] > nums[myQ.peekLast()]) {
        myQ.removeLast();
      }
      myQ.addLast(i);
      if (i >= k - 1) {
        int f = myQ.peekFirst();
        result.add(f == i - k + 1? nums[myQ.removeFirst()]: nums[myQ.peekFirst()]);
      }
    }
    return result;
  }
}

