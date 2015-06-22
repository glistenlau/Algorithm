/**
 * Search Insert Position
 * http://www.lintcode.com/en/problem/search-insert-position/
 *
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume NO duplicates in the array.
 *
 * Example
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 */
public class Solution {
  /**
   * param A : an integer sorted array
   * param target :  an integer to be inserted
   * return : an integer
   */
  public int searchInsert(int[] A, int target) {
    // write your code her
    if (A.length == 0) {
      return 0;
    }
    int left = 0;
    int right = A.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A[mid] == target) {
        return mid;
      } else if (A[mid] < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (A[left] >= target) {
      return left;
    } else if (A[right] >= target) {
      return right;
    } else {
      return right + 1;
    }
  }
}