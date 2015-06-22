/**
 * Permutations
 * http://www.lintcode.com/en/problem/permutations/
 *
 * Given a list of numbers, return all possible permutations.
 *
 * Example
 * For nums = [1,2,3], the permutations are:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 */
class Solution {
  /**
   * @param nums: A list of integers.
   * @return: A list of permutations.
   */
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.size() == 0) {
      return result;
    }
    permute(nums, 0, result);
    return result;
  }

  private void permute(ArrayList<Integer> nums, int index,
                       ArrayList<ArrayList<Integer>> result) {
    if (index == nums.size()) {
      result.add(new ArrayList<Integer>(nums));
      return;
    }

    HashSet<Integer> takenIndex = new HashSet<Integer>();
    for (int i = index; i < nums.size(); i++) {
      if (takenIndex.contains(i)) {
        continue;
      }
      takenIndex.add(i);
      swap(nums, i, index);
      permute(nums, index + 1, result);
      swap(nums, i, index);
    }
  }

  private void swap(ArrayList<Integer> nums, int A, int B) {
    int temp = nums.get(A);
    nums.set(A, nums.get(B));
    nums.set(B, temp);
  }
}