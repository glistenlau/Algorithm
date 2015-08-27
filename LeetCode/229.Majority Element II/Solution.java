public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ans;
    }

    int num1 = 0;
    int num2 = 0;
    int count1 = 0;
    int count2 = 0;

    for (int i = 0; i < nums.length; i++) {
      if (num1 == nums[i]) {
        count1++;
      } else if (num2 == nums[i]) {
        count2++;
      } else if (count1 == 0) {
        num1 = nums[i];
        count1++;
      } else if (count2 == 0) {
        num2 = nums[i];
        count2++;
      } else {
        count1--;
        count2--;
      }
    }

    count1 = 0;
    count2 = 0;
    for (int num: nums) {
      if (num == num1) {
        count1++;
      }
      if (num == num2) {
        count2++;
      }
    }

    if (count1 > nums.length / 3) {
      ans.add(num1);
    }
    if (count2 > nums.length / 3 && num1 != num2) {
      ans.add(num2);
    }

    return ans;
  }
}