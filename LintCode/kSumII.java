/**
 * k Sum II
 * http://www.lintcode.com/en/problem/k-sum-ii/
 *
 * Given n unique integers, number k(1<=k<=n) and target. Find all possible k
 * integers where their sum is target.
 *
 * Example
 * Given [1, 2, 3, 4], k = 2, target = 5, [1, 4] and [2, 3] are possible
 * solutions.
 */

public class Solution {
  /**
   * @param A: an integer array.
   * @param k: a positive integer (k <= length(A))
   * @param target: a integer
   * @return a list of lists of integer
   */
  public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (A == null || A.length == 0) {
      return result;
    }
    kSumHelper(A, k, target, 0, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void kSumHelper(int[] A, int k, int target, int pos, int sum, ArrayList<Integer> taken, ArrayList<ArrayList<Integer>> result) {
    if (taken.size() == k) {
      if (sum == target) {
        result.add(new ArrayList<Integer>(taken));
      }
      return;
    }

    for (int i = pos; i < A.length; i++) {
      if (A[i] + sum > target) {
        continue;
      }
      sum += A[i];
      taken.add(A[i]);
      kSumHelper(A, k, target, i + 1, sum, taken, result);
      taken.remove(taken.size() - 1);
      sum -= A[i];
    }
  }
}

