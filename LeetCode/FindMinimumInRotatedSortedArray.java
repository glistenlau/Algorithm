/**
 * Created by YiLIU on 6/9/15.
 */
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int n = nums.length;
    int left = 0;
    int right = n - 1;
    while (left < right && nums[left] >= nums[right]) {
      int mid = left / 2 + right / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else
        right = mid;
      }
    return nums[left];
  }
}
