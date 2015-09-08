/**
 * Permutation Sequence
 * www.lintcode.com/en/problem/permutation-sequence/
 *
 * Given n and k, return the k-th permutation sequence.
 */
class Solution {
  /**
   * @param n: n
   * @param k: the kth permutation
   * @return: return the k-th permutation
   */
  public String getPermutation(int n, int k) {
    int f = getFactor(n);
    StringBuilder ans = new StringBuilder();
    List<Integer> nums = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      nums.add(i);
    }

    while (!nums.isEmpty()) {
      f /= nums.size();
      int order = (k - 1) / f;
      k -= f * (order);
      ans.append(nums.get(order));
      nums.remove(order);
    }


    return ans.toString();
  }

  private int getFactor(int n) {
    int ans = 1;
    for (int i = n; i > 1; i--) {
      ans *= i;
    }

    return ans;
  }
}

