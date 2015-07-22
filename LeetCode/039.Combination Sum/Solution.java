public class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    dfsHelper(candidates, target, 0, 0, new ArrayList<Integer>(), result);

    return result;
  }

  private void dfsHelper(int[] candidates, int target, int pos, int sum, List<Integer> taken, List<List<Integer>> result) {
    if (sum == target) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }
    if (sum > target) {
      return;
    }

    for (int i = pos; i < candidates.length; i++) {
      taken.add(candidates[i]);
      dfsHelper(candidates, target, i, sum + candidates[i], taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}