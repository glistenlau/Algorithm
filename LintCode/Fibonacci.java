/**
 * Fibonacci
 * Find the Nth number in Fibonacci sequence.
 * A Fibonacci sequence is defined as follow:
 *   The first two number are 0 and 1.
 *   The ith number is the sum of i - 1th number and i - 2th number.
 * The first ten numbers in Fibonacci sequence is :
 * 0, 1, 1 ,2, 3, 5, 8, 13, 21, 34 ...
 *
 * Example
 * Given 1, return 0.
 * Given 2, return 1.
 * Given 10, return 34.
 */
class Solution {
  /**
   * @param n: an integer
   * @return an integer f(n)
   */
  public int fibonacci(int n) {
    // write your code here
    int pre = 1;
    int prePre = 0;
    if (n == 1) {
      return prePre;
    }

    for (int i = 3; i <= n; i++) {
      int cur = pre + prePre;
      prePre = pre;
      pre = cur;
    }

    return pre;
  }
}
