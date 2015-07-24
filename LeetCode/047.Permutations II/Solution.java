// Solution 1: recurtion
public class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    boolean[] visited = new boolean[nums.length];
    Arrays.sort(nums);
    helper(nums, new ArrayList<Integer>(), result, visited);
    return result;
  }

  private void helper(int[] nums, List<Integer> taken, List<List<Integer>> result,
                      boolean[] visited) {
    if (taken.size() == nums.length) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if ((i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) || visited[i]) {
        continue;
      }
      taken.add(nums[i]);
      visited[i] = true;
      helper(nums, taken, result, visited);
      visited[i] = false;
      taken.remove(taken.size() - 1);
    }
  }
}
