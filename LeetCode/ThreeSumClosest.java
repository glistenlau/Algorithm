import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import com.sun.tools.internal.ws.wsdl.document.jaxws.*;
import com.sun.tools.internal.ws.wsdl.document.jaxws.Exception;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

/**
 * Created by YiLIU on 6/15/15.
 */
public class ThreeSumClosest {
  public int threeSumClosest(int[] nums, int target) {
    if (nums.length < 3) {
      return 0;
    }
    Arrays.sort(nums);
    int closest = Math.abs(nums[0] + nums[1] + nums[nums.length - 1] - target);
    int result = nums[0] + nums[1] + nums[nums.length - 1];

    for (int i = 0; i < nums.length; ++i) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[i] + nums[left] + nums[right];
        if (Math.abs(sum - target) < closest) {
          closest = Math.abs(sum - target);
          result = sum;
        }
        if (sum == target) {
          return target;
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
    return result;
  }

  public static void main(String[] args) {
    int[] test = {-1, 2, 1, -4};
    System.out.println(new ThreeSumClosest().threeSumClosest(test, 1));
  }
}
