/**
 * Search for a Range
 * http://www.lintcode.com/en/problem/search-for-a-range/
 *
 * Given a sorted array of n integers, find the starting and ending position of
 * a given target value.
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 */
public class Solution {
  /**
   *@param A : an integer sorted array
   *@param target :  an integer to be inserted
   *return : a list of length 2, [index1, index2]
   */
  public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    int left = 0;
    int right = A.size() - 1;
    ArrayList<Integer> result = new ArrayList<>();
    if (A.size() == 0) {
      result.add(-1);
      result.add(-1);
      return result;
    }
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A.get(mid) == target) {
        right = mid;
      } else if (A.get(mid) < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (A.get(left) == target) {
      result.add(left);
    } else if (A.get(right) == target) {
      result.add(right);
    } else {
      result.add(-1);
      result.add(-1);
      return result;
    }
    left = 0;
    right = A.size() - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A.get(mid) == target) {
        left = mid;
      } else if (A.get(mid) < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (A.get(right) == target) {
      result.add(right);
    } else if (A.get(left) == target) {
      result.add(left);
    }

    return result;
  }
}