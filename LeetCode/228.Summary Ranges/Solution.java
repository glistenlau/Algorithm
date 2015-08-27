public class Solution {
  public List<String> summaryRanges(int[] nums) {
    List<String> ans = new ArrayList<String>();
    if (nums == null || nums.length == 0) {
      return ans;
    }

    int left = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1] + 1) {
        ans.add(getPattern(nums, left, i - 1));
        left = i;
      }
    }
    ans.add(getPattern(nums, left, nums.length - 1));

    return ans;
  }

  private String getPattern(int[] nums, int start, int end) {
    if (start == end) {
      return "" + nums[start];
    } else {
      return "" + nums[start] + "->" + nums[end];
    }
  }
}