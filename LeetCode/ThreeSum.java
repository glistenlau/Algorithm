import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YiLIU on 6/14/15.
 */
public class ThreeSum {
  private List<List<Integer>> result = new ArrayList<>();

  public List<List<Integer>> threeSumR(int[] nums) {
    long startTime = System.currentTimeMillis();
    Arrays.sort(nums);
    List<Integer> taken = new ArrayList<>();
    threeSumHelper(nums, 0, taken, 0);
    long endTime = System.currentTimeMillis();
    System.out.println("Run Time: " + (endTime - startTime) + " ms");
    return result;
  }

  private void threeSumHelper(int[] nums, int index, List<Integer>
      taken, int sofar) {
    List<Integer> copy = new ArrayList<>();
    copy.addAll(taken);
    int pre = nums.length > 0 ? nums[0] : 0;

    for (int i = index; i < nums.length; ++i) {
      if (i != index && nums[i] == pre) {
        continue;
      }
      pre = nums[i];
      if (taken.size() + 1 == 3 && sofar + nums[i] == 0) {
        copy.add(nums[i]);
        result.add(copy);
        return;
      } else if (taken.size() < 2) {
        copy.add(nums[i]);
        threeSumHelper(nums, i + 1, copy, sofar + nums[i]);
        copy.clear();
        copy.addAll(taken);
      }
    }
  }

  public List<List<Integer>> threeSum(int[] nums) {
    long startTime = System.currentTimeMillis();
    List<List<Integer>> result = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return result;
    }
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; ++i) {
      int left = i + 1;
      int right = nums.length - 1;
      if (i != 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (sum == 0) {
          List<Integer> temp = new ArrayList<>();
          temp.add(nums[i]);
          temp.add(nums[left]);
          temp.add(nums[right]);
          result.add(temp);
          ++left;
          --right;
          while (left < right && nums[left] == nums[left - 1]) {
            ++left;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            --right;
          }
        } else if (sum < 0) {
          ++left;
        } else {
          --right;
        }
      }
    }
    long endTime = System.currentTimeMillis();
    System.out.println("Run Time: " + (endTime - startTime) + " ms");
    return result;
  }

  public static void main(String[] args) {
    int[] test = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
    System.out.println(new ThreeSum().threeSum(test));
    System.out.println(new ThreeSum().threeSumR(test));
  }
}
