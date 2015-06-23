/**
 * Created by YiLIU on 6/19/15.
 */
public class BinarySearch {
  public int binarySearch(int[] nums, int target) {
    //write your code here
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        right = mid;
      } else if (nums[mid] > target) {
        right = mid;
      } else {
        left = mid;
      }
    }
    if (nums[left] == target) {
      return left;
    }
    if (nums[right] == target) {
      return right;
    }
    return -1;
  }
}
