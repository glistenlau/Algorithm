/**
 * SubSets II
 * http://www.lintcode.com/en/problem/subsets-ii/
 *
 * Given a list of numbers that may has duplicate numbers, return all possible
 * subsets
 *
 * Example
 * If S = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 */
public class SubsetsII {
  class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
      // write your code here
      ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
      if (S == null || S.size() == 0) {
        return result;
      }
      Collections.sort(S);
      helper(S, 0, new ArrayList<Integer>(), result);
      return result;
    }

    private void helper(ArrayList<Integer> S, int index, ArrayList<Integer> taken, ArrayList<ArrayList<Integer>> result) {
      result.add(new ArrayList<Integer>(taken));
      for (int i = index; i < S.size(); i++) {
        if (i != index && S.get(i - 1) == S.get(i)) {
          continue;
        }
        taken.add(S.get(i));
        helper(S, i + 1, taken, result);
        taken.remove(taken.size() - 1);
      }
    }
  }
}
