// Solution1: recursion
public class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nums == null || nums.length == 0) {
      return result;
    }
    helper(nums, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper(int[] nums, List<Integer> taken, List<List<Integer>> result) {
    if (taken.size() == nums.length) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (taken.contains(nums[i])) {
        continue;
      }
      taken.add(nums[i]);
      helper(nums, taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}

// Solution2: Iteration
public List<List<Integer>> permute(int[] nums) {
  LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
  if (nums == null || nums.length == 0) {
    return result;
  }

  result.add(new ArrayList<Integer>());

  for (int n: nums) {

    int size = result.size();
    for (int i = 0; i < size; i++) {

      List<Integer> curt = result.pollFirst();
      for (int j = 0; j <= curt.size(); j++) {
        List<Integer> temp = new ArrayList<Integer>(curt);
        temp.add(j, n);
        result.add(temp);
      }
    }
  }

  return result;
}