/**
 * Permutations II
 * http://www.lintcode.com/en/problem/permutations-ii/
 *
 * Given a list of numbers with duplicate number in it. Find all unique
 * permutations.
 *
 * Example
 * For numbers [1,2,2] the unique permutations are:
 * [
 *  [1,2,2],
 *  [2,1,2],
 *  [2,2,1]
 * ]
 */
class Solution {
  /**
   * @param nums: A list of integers.
   * @return: A list of unique permutations.
   */
  public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.size() == 0) {
      return result;
    }
    permuteHelper(nums, new ArrayList<Integer>(), new ArrayList<Integer>(), result);
    return result;
  }

  private void permuteHelper(ArrayList<Integer> nums, ArrayList<Integer> index, ArrayList<Integer> taken, ArrayList<ArrayList<Integer>> result) {
    if (taken.size() == nums.size()) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }
    HashSet<Integer> indexDone = new HashSet<Integer>();
    for (int i = 0; i < nums.size(); i++) {
      if (indexDone.contains(nums.get(i)) || index.contains(i)) {
        continue;
      }
      index.add(i);
      indexDone.add(nums.get(i));
      taken.add(nums.get(i));
      permuteHelper(nums, index, taken, result);
      taken.remove(taken.size() - 1);
      index.remove(index.size() - 1);
    }
  }
}
