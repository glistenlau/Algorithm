/**
 * Combination Sum II
 * www.lintcode.com/en/problem/combination-sum-ii/
 * Given a collection of candidate numbers and a target number, find all unique combinations
 * in where the candidate numbers sums to target.
 *
 * Each number may only be used once in the combination.
 *
 * Example
 * For example, given candidate set 10, 1, 6, 7, 2, 1, 5 and target 8,
 * A solution set is:
 *   [1, 7]
 *   [1, 2, 5]
 *   [2, 6]
 *   [1, 1, 6]
 */
public class Solution {
  /**
   * @param num: Given the candidate numbers
   * @param target: Given the target number
   * @return: All the combinations that sum to target
   */
  public List<List<Integer>> combinationSum2(int[] num, int target) {
    // write your code here
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    if (num == null || num.length == 0) {
      return ans;
    }
    boolean[] visited = new boolean[num.length];
    Arrays.sort(num);

    helper(num, target, 0, 0, new ArrayList<Integer>(), ans, visited);
    return ans;
  }

  private void helper(int[] nums, int target, int pos, int sum, List<Integer> taken, List<List<Integer>> ans, boolean[] visited) {
    if (sum > target) {
      return;
    }
    if (sum == target) {
      ans.add(new ArrayList<>(taken));
      return;
    }

    for (int i = pos; i < nums.length; i++) {
      if (i > 0 && !visited[i - 1] && nums[i] == nums[i - 1]) {
        continue;
      }
      visited[i] = true;
      taken.add(nums[i]);
      sum += nums[i];
      helper(nums, target, i + 1, sum, taken, ans, visited);
      sum -= nums[i];
      taken.remove(taken.size() - 1);
      visited[i] = false;
    }
  }
}
