import java.util.ArrayList;

/**
 * Created by YiLIU on 6/22/15.
 */
public class Permutations {
  public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (nums == null || nums.size() == 0) {
      return result;
    }
    helper(nums, new ArrayList<Integer>(), new ArrayList<Integer>(), result);
    return result;
  }

  private void helper(ArrayList<Integer> nums, ArrayList<Integer> taken,
                      ArrayList<Integer> index, ArrayList<ArrayList<Integer>>
                      result) {
    if (taken.size() == nums.size()) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }
    for (int i = 0; i < nums.size(); ++i) {
      if (index.contains(i)) {
        continue;
      }
      taken.add(nums.get(i));
      index.add(i);
      helper(nums, taken, index, result);
      taken.remove(taken.size() - 1);
      index.remove(index.size() - 1);
    }
  }

  public static void main(String[] args) {
    ArrayList<Integer> test = new ArrayList<Integer>();
    test.add(1);
    new Permutations().permute(test);
  }
}
