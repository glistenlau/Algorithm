public class Solution {
  public int findMin(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int tail = nums.length - 1;
    int left = 0;
    int right = nums.length - 1;

    while (left + 1 < right && tail >= 0) {
      int mid = left + (right - left) / 2;
      if (nums[mid] > nums[tail]) {
        left = mid;
      } else if (nums[mid] < nums[tail]) {
        right = mid;
      } else {
        tail--;
        right = right > tail? tail: right;
      }
    }

    return Math.min(nums[left], nums[right]);
  }
}