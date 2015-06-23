/**
 * Created by YiLIU on 6/9/15.
 */
public class FindMinimumInRotatedSortedArray {
  public int findMin(int[] num) {
    // write your code here
    if (num == null || num.length == 0) {
      return Integer.MIN_VALUE;
    }
    int left = 0;
    int right = num.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (num[mid] > num[right]) {
        left = mid;
      } else {
        right = mid;
      }
    }
    return num[left] < num[right] ? num[left] : num[right];
  }
}
