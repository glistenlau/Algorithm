public class Solution{
  public int findDuplicate(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 1;
    int right = nums.length;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      int count = countFreq(nums, mid);
      if (count > mid) {
        right = mid;
      } else {
        left = mid;
      }
    }
    boolean hasLeft = false;
    boolean hasRight = false;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == left) {
        if (hasLeft) {
          return left;
        }
        hasLeft = true;
      }
      if (nums[i] == right) {
        if (hasRight) {
          return right;
        }
        hasRight = true;
      }
    }
    return -1;
  }

  private int countFreq(int[] nums, int tar) {
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= tar) {
        count++;
      }
    }

    return count;
  }
}