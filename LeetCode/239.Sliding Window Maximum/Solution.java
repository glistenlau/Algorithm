public class Solution {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] ans = new int[nums.length - k + 1];
    int left = 0;

    Deque<Integer> myQ = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
      while (!myQ.isEmpty() && nums[i] > nums[myQ.peekLast()]) {
        myQ.removeLast();
      }
      myQ.addLast(i);
      if (i - left == k - 1) {
        ans[left] = nums[myQ.peekFirst()];
        if (left == myQ.peekFirst()) {
          myQ.removeFirst();
        }
        left++;
      }
    }

    return ans;
  }
}