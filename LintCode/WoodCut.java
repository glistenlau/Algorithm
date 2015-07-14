/**
 * Given n pieces of wood with length L[i] (integer array). Cut them into
 * small pieces to guarantee you could have equal or more than k pieces with
 * the same length. What is the longest length you can get from the n pieces
 * of wood? Given L & K, return the maximum length of the small pieces.
 *
 * Example
 * For L = [232, 124, 456], k = 7, return 114.
 */

public class Solution {
  /**
   *@param L: Given n pieces of wood with length L[i]
   *@param k: An integer
   *return: The maximum length of the small pieces.
   */
  public int woodCut(int[] L, int k) {
    if (L == null || L.length == 0 || k == 0) {
      return 0;
    }

    long sum = 0;
    for (int len : L) {
      sum += len;
    }
    if (sum < k) {
      return 0;
    }

    int right = (int) (sum / k);
    int left = 1;

    while(left + 1 < right) {
      int mid = left + (right - left) / 2;
      int count = 0;
      for (int len : L) {
        count += len / mid;
      }

      if (count >= k) {
        left = mid;
      } else {
        right = mid;
      }
    }
    int count = 0;
    for (int len : L) {
      count = len / right;
    }
    if (count >= k) {
      return right;
    }
    else {
      return left;
    }
  }
}
