public class Solution {
  public int numTrees(int n) {
    int[] trees = new int[n + 1];
    trees[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= i - 1; j++) {
        trees[i] += trees[j] * trees[i - 1 - j];
      }
    }
    return trees[n];
  }
}