public class Solution {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    helper(nums, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper(int[] nums, int pos, List<Integer> taken, List<List<Integer>> result) {
    result.add(new ArrayList<Integer>(taken));
    if (taken.size() == nums.length) {
      return;
    }
    for (int i = pos; i < nums.length; i++) {
      taken.add(nums[i]);
      helper(nums, i + 1, taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}