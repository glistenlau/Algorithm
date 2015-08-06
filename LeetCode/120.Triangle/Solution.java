public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int[] sums = new int[triangle.size()];
    for (int r = triangle.size() - 1; r >= 0; r--) {
      for (int c = 0; c < triangle.get(r).size(); c++) {
        if (r == triangle.size() - 1) {
          sums[c] = triangle.get(r).get(c);
        } else {
          sums[c] = triangle.get(r).get(c) + Math.min(sums[c], sums[c + 1]);
        }
      }
    }
    return sums[0];
  }
}