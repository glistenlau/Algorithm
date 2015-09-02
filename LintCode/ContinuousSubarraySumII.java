/**
 * Coninuous Subarray Sum II
 * www.lintcode.com/en/problem/continuous-subarray-sum-ii/
 *
 * Given an integer array, find a continuous rotate subarray where the sum of numbers
 * is the biggest. Your code should return the index of the first number and the index
 * of the last number.(If their are duplicate answer, return anyone. The answer can be
 * rotate array or non-rotate array).
 *
 * Example
 * Give[3, 1, -100, -3, 4], return [4, 1].
 */

public class Solution {
  /**
   * @param A an integer array
   * @return  A list of integers includes the index of the first number and the index of the last number
   */
  public ArrayList<Integer> continuousSubarraySumII(int[] A) {
    // Write your code here
    int[] sum = new int[A.length + 1];
    for (int i = 1; i <= A.length; i++) {
      sum[i] = sum[i - 1] + A[i - 1];
    }

    int[] max = findMax(sum);
    int[] min = findMin(sum);

    if (min[2] == sum[A.length] || max[2] >= sum[A.length] - min[2]) {
      return new ArrayList<>(Arrays.asList(max[0], max[1]));
    } else {
      return new ArrayList<>(Arrays.asList(min[1] + 1, min[0] - 1));
    }
  }

  private int[] findMax(int[] sum) {
    int preMin = 0;
    int first = 0;
    int last = 0;
    int max = Integer.MIN_VALUE;

    for (int i = 1; i < sum.length; i++) {
      if (sum[i] - sum[preMin] > max) {
        max = sum[i] - sum[preMin];
        first = preMin;
        last = i - 1;
      }
      if (sum[i] < sum[preMin]) {
        preMin = i;
      }
    }

    return new int[]{first, last, max};
  }

  private int[] findMin(int[] sum) {
    int preMax = 0;
    int first = 0;
    int last = 0;
    int min = Integer.MAX_VALUE;

    for (int i = 1; i < sum.length; i++) {
      if (sum[i] - sum[preMax] < min) {
        min = sum[i] - sum[preMax];
        first = preMax;
        last = i - 1;
      }
      if (sum[i] > sum[preMax]) {
        preMax = i;
      }
    }

    return new int[]{first, last, min};
  }
}
