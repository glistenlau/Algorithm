/**
 * Combination Sum
 * http://www.lintcode.com/en/problem/combination-sum/
 *
 * Given a set of candidate numbers(C) and a target number(T), find all
 * unique combinations in C where the candidate numbers sums to T.
 *
 * Than same repeated number may be chosen from C unlimited number of times.
 *
 * Example
 * Given candidate set 2,3,5,6 and target 7, A solution set is:
 * [7]
 * [2, 2, 3]
 */

public class Solution {
  /**
   * @param candidates: A list of integers
   * @param target:An integer
   * @return: A list of lists of integers
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    combination(candidates, target, 0, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void combination(int[] candidates, int target, int pos, int sum, List<Integer> taken, List<List<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      if (candidates[i] + sum > target) {
        return;
      }
      sum += candidates[i];
      taken.add(candidates[i]);
      combination(candidates, target, i, sum, taken, result);
      taken.remove(taken.size() - 1);
      sum -= candidates[i];
    }
  }
}
