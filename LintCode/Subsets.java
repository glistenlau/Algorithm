import java.util.ArrayList;
import java.util.Collections;

/**
 * Subsets
 * http://www.lintcode.com/en/problem/subsets/#
 *
 * Given a set of distinct integers, return all possible subsets.
 *
 * Example
 * If S = [1,2,3], a solution is:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

class Solution {
  /**
   * @param S: A set of numbers.
   * @return: A list of lists. All valid subsets.
   */
  public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (S == null || S.size() == 0) {
      return result;
    }
    Collections.sort(S);
    helper(S, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void helper(ArrayList<Integer> S, int index, ArrayList<Integer> taken,
                      ArrayList<ArrayList<Integer>> result) {
    result.add(taken);
    if (taken.size() == S.size()) {
      return;
    }

    for (int i = index; i < S.size(); ++i) {
      taken.add(S.get(i));
      helper(S, i + 1, taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}