public class Solution {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    Arrays.sort(nums);
    dfsHelper(nums, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void dfsHelper(int[] nums, int pos, List<Integer> taken, List<List<Integer>> result) {
    result.add(new ArrayList(taken));
    if (taken.size() == nums.length) {
      return;
    }

    for (int i = pos; i < nums.length; i++) {
      if (i != pos && nums[i] == nums[i - 1]) {
        continue;
      }
      taken.add(nums[i]);
      dfsHelper(nums, i + 1, taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}