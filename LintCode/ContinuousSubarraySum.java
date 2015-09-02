/**
 * Continuous Subarray Sum
 * www.lintcode.com/en/problem/continuous-subarray-sum/
 *
 * Given an integer array, find a continuous subarray where the sum of numbers is the biggest.
 * Your code should return the index of the first number and the index of the last number.(If their
 * are dulicate answer, return anyone).
 *
 * Example
 * Give [-3, 1, 3, -3, 4], return[1, 4]
 */
public class Solution {
  /**
   * @param A an integer array
   * @return  A list of integers includes the index of the first number and the index of the last number
   */
  public ArrayList<Integer> continuousSubarraySum(int[] A) {
    // Write your code here
    if (A == null || A.length == 0) {
      return new ArrayList<>();
    }

    int[] sum = new int[A.length + 1];

    for (int i = 1; i <= A.length; i++) {
      sum[i] = sum[i - 1] + A[i - 1];
    }

    int preMin = 0;
    int first = 0;
    int last = 0;
    int ans = Integer.MIN_VALUE;

    for (int i = 1; i <= A.length; i++) {
      if (sum[i] - sum[preMin] > ans) {
        ans = sum[i] - sum[preMin];
        first = preMin;
        last = i - 1;
      }
      if (sum[i] < sum[preMin]) {
        preMin = i;
      }
    }

    ArrayList<Integer> rst = new ArrayList<>();
    rst.add(first);
    rst.add(last);
    return rst;
  }
}
