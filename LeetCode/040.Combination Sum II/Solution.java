public class Solution {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) {
      return result;
    }
    Arrays.sort(candidates);
    dfsHelper(candidates, target, 0, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void dfsHelper(int[] nums, int tar, int pos, int sum, List<Integer> taken, List<List<Integer>> result) {
    if (sum == tar) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }

    if (sum > tar) {
      return;
    }

    for (int i = pos; i < nums.length; i++) {
      if (i != pos && nums[i] == nums[i - 1]) {
        continue;
      }
      taken.add(nums[i]);
      dfsHelper(nums, tar, i + 1, sum + nums[i], taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}