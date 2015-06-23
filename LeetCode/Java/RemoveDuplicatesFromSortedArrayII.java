/**
 * Created by YiLIU on 6/21/15.
 */
public class RemoveDuplicatesFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int count = 1;
    int same = 1;
    for (int i = 1; i < nums.length; ++i) {
      if (nums[i] == nums[i - 1] && same > 1) {
        continue;
      }
      if (nums[i] == nums[i - 1]) {
        same += 1;
      } else {
        same = 1;
      }
      nums[count++] = nums[i];
    }
    return count;
  }

  public static void main(String[] args) {
    int[] test = {-1014,-1014,-1014,-1006,-1005,-1004,-1002,-1001,-1000,-999,
        -999,-998,-997,-997,-997,-996,-995,-995,-994,-993,-992,-992,-992,
        -992,-991,-991,-991,-990,-990,-990,-990,-990,-989,-988,-988,-987,-987,-986,-986,-985,-985};
    System.out.println(new RemoveDuplicatesFromSortedArrayII()
        .removeDuplicates(test));
  }
}
