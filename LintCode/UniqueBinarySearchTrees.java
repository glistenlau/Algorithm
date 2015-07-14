/**
 * Unique Binary Search Trees
 * www.lintcode.com/en/problem/unique-binary-search-trees/
 *
 * Given n, how many structurally unique BSTs (binary search trees) that
 * store values 1...n?
 *
 * Example
 * Given n = 3, there are a total of 5 unique BST's.
 * 1      3       3       2       1
 *  \    /       /      /  \       \
 *   3  2       1      1    3       2
 *  /  /         \                   \
 * 2  1           2                   3
 */

public class Solution {
  /**
   * @paramn n: An integer
   * @return: An integer
   */
  public int numTrees(int n) {
    if (n == 0) {
      return 1;
    }
    int[] count = new int[n + 1];
    count[0] = 1;
    count[1] = 1;
    for (int i = 2; i <= n ; i++) {
      for (int j = 0; j < i; j++) {
        count[i] += count[j] * count[i - 1 - j];
      }
    }
    return count[n];
  }
}
