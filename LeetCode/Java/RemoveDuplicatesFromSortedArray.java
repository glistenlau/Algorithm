/**
 * Created by YiLIU on 6/17/15.
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0)
      return 0;
    int index = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1]) {
        continue;
      } else {
        nums[index++] = nums[i];
      }
    }
    return index;
    }
  }

