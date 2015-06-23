import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YiLIU on 6/15/15.
 */
public class FourSum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);

    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      for (int j = i + 1; j < nums.length; ++j) {
        if (j > i + 1 && nums[j] == nums[j - 1]) {
          continue;
        }
        int left = j + 1;
        int right = nums.length - 1;
        while (left < right) {
          int sum = nums[i] + nums[j] + nums[left] + nums[right];
          if (sum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.add(nums[j]);
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
          } else if (sum < target) {
            ++left;
            while (left < right && nums[left] == nums[left - 1]) {
              ++left;
            }
          } else {
            --right;
            while (left < right && nums[right] == nums[right + 1]) {
              --right;
            }
          }
        }
      }
    }
    return result;
  }

  public List<List<Integer>> fourSumR(int[] nums, int target) {
    Arrays.sort(nums);
    return helper(nums, 0, target, new ArrayList<Integer>(), new ArrayList<>
        ());
  }

  private List<List<Integer>> helper(int[] nums, int index, int target, List<Integer>
      taken, List<List<Integer>> result) {
    if (nums.length == 0) {
      return null;
    }


    int sofar = 0;
    for (int n : taken) {
      sofar += n;
    }

    for (int i = index; i < nums.length; ++i) {
      if (i > index && nums[i] == nums[i - 1]) {
        continue;
      }
      List<Integer> temp = new ArrayList<>();
      temp.addAll(taken);
      if (sofar + nums[i] == target && taken.size() == 3) {
        temp.add(nums[i]);
        result.add(temp);
        return result;
      } else if (taken.size() < 3) {
        temp.add(nums[i]);
        helper(nums, i + 1, target, temp, result);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] test = {-497, -494, -484, -477, -453, -453, -444, -442, -428, -420, -401,
        -393, -392, -381, -357, -357, -327, -323, -306, -285, -284, -263, -262, -254, -243, -234, -208, -170, -166, -162, -158, -136, -133, -130, -119, -114, -101, -100, -86, -66, -65, -6, 1, 3, 4, 11, 69, 77, 78, 107, 108, 108, 121, 123, 136, 137, 151, 153, 155, 166, 170, 175, 179, 211, 230, 251, 255, 266, 288, 306, 308, 310, 314, 321, 322, 331, 333, 334, 347, 349, 356, 357, 360, 361, 361, 367, 375, 378, 387, 387, 408, 414, 421, 435, 439, 440, 441, 470, 492};
    System.out.println(new FourSum().fourSum(test, 1682));
  }
}
