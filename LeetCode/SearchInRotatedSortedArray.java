/**
 * Created by YiLIU on 6/21/15.
 */
public class SearchInRotatedSortedArray {
  public int search(int[] A, int target) {
    if (A == null || A.length == 0) {
      return -1;
    }
    int left = 0;
    int right = A.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A[mid] == target) {
        return mid;
      }
      if (A[left] < A[mid]) {
        if (A[left] <= target && target <= A[mid]) {
          right = mid;
        } else {
          left = mid;
        }
      } else {
        if (A[mid] <= target && target <= A[right]) {
          left = mid;
        } else {
          right = mid;
        }
      }
    }
    if (A[left] == target) {
      return left;
    }
    if (A[right] == target) {
      return right;
    }
    return -1;
  }
}
