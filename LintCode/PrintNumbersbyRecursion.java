/**
 * Print Numbers by Recursion
 * www.lintcode.com/en/problem/print-numbers-by-recursion/
 *
 * Print numbers from 1 to the largest number with N digits by recursion.
 *
 * Example
 * Given N = 1, return {1, 2, 3, 4, 5, 6, 7, 8, 9}.
 * Given N = 2, return {1, 2, 3, 4, 5, 6, 7, 8 ,9, 10, 11, ..., 99}.
 */
public class Solution {
  /**
   * @param n: An integer.
   * return : An array storing 1 to the largest number with n digits.
   */
  public List<Integer> numbersByRecursion(int n) {
    // write your code here
    List<Integer> ans = new ArrayList<>();
    if (n < 1) {
      return ans;
    }
    int largest = 9;
    for (int i = 2; i <= n; i++) {
      largest *= 10;
      largest += 9;
    }

    getNumber(1, largest, ans);
    return ans;
  }

  private void getNumber(int s, int e, List<Integer> ans) {
    if (s == e) {
      ans.add(s);
      return;
    }

    int mid = s + (e - s) / 2;

    getNumber(s, mid, ans);
    getNumber(mid + 1, e, ans);
  }
}
