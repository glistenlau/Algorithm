// Solution 1: count
public class Solution {
  public int majorityElement(int[] nums) {
    int max = 0;
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (count == 0) {
        max = nums[i];
        count++;
      } else {
        if (nums[i] == max) {
          count++;
        } else {
          count--;
        }
      }
    }
    return max;
  }
}

// Solution 2: hashtable
public class Solution {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> count = new HashMap<>();
    for (int num: nums) {
      if (!count.containsKey(num)) {
        count.put(num, 0);
      }
      count.put(num, count.get(num) + 1);
      if (count.get(num) > nums.length / 2) {
        return num;
      }
    }

    return -1;
  }
}

// Solutin 3: divide and conquer
public class Solution {
  public int majorityElement(int[] nums) {
    return findMajority(nums, 0, nums.length - 1);
  }

  private int findMajority(int[] nums, int start, int end) {
    if (start == end) {
      return nums[start];
    }
    int mid = start + (end - start) / 2;
    int lM = findMajority(nums, start, mid);
    int rM = findMajority(nums, mid + 1, end);
    if (lM == rM) {
      return lM;
    }

    int lCount = 0;
    int rCount = 0;
    for (int i = start; i <= end ; i++) {
      lCount += nums[i] == lM? 1: 0;
      rCount += nums[i] == rM? 1: 0;
    }

    return lCount > rCount? lM: rM;
  }
}