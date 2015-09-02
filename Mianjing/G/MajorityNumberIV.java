/**
 * Find the most popular number in an array of interger. The 'popular number' is
 * defined as the number occurs more than n/4, where n is the length of array.
 * The array is already sorted.
 *
 * 这道题第一眼看和LeetCode 上Majority Number II 差不多， 但是相比多了sorted的条件，所以自然的
 * 想到二进制搜索。由于要超过四分之一，所以如果存在符合条件的数，则把数组四等分的三个点中必有一个是这个
 * 数。用二进制搜索分别搜索这三个数的开始和结束，取最大的就好。
 */
public class MajorityNumberIV {
  public int findMajorityNumber(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int n = nums.length / 4;
    int first = nums[n];
    int second = nums[2 * n];
    int third = nums[3 * n];

    int firstLen = findEnd(nums, first) - findStart(nums, first) + 1;
    int secondLen = findEnd(nums, second) - findStart(nums, second) + 1;
    int thirdLen = findEnd(nums, third) - findStart(nums, third) + 1;

    int maxLen = Math.max(firstLen, Math.max(secondLen, thirdLen));
    if (maxLen > nums.length / 4) {
      return maxLen == firstLen? first: maxLen == secondLen? second: third;
    }

    return -1;
  }

  private int findEnd(int[] nums, int tar) {
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] <= tar) {
        left = mid;
      } else {
        right = mid;
      }
    }


    if (nums[right] == tar) {
      return right;
    }
    return left;
  }

  private int findStart(int[] nums, int tar) {
    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] >= tar) {
        right = mid;
      } else {
        left = mid;
      }
    }

    if (nums[left] == tar) {
      return left;
    }
    return right;
  }

  public static void main(String[] args) {
    MajorityNumberIV test = new MajorityNumberIV();
    System.out.println(test.findMajorityNumber(new int[]{1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 7}));
  }
}
