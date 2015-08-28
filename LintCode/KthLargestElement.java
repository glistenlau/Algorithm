/**
 * Kth Largest Element
 * www.lintcode.com/en/problem/kth-largest-element/
 *
 * Find K-th largest element in an array.
 *
 * Example
 * In array [9, 3, 2, 4, 8], the 3rd largest element is 4.
 * In array [1, 2, 3, 4, 5], the 1st largest element is 5, 2nd largest element is 4, 3rd largest elemnt is 3 and etc.
 */
class Solution {
  //param k : description of k
  //param numbers : array of numbers
  //return: description of return
  public int kthLargestElement(int k, ArrayList<Integer> numbers) {
    // write your code here
    if (numbers == null || numbers.size() == 0) {
      return -1;
    }

    return quickSelect(k, numbers, 0, numbers.size() - 1);
  }

  private int quickSelect(int k, ArrayList<Integer> nums, int left, int right) {
    if (left > right) {
      return -1;
    }

    int mid = nums.get(left + (right - left) / 2);

    int l = left;
    int r = right;
    while (l <= r) {
      while (l <= r && nums.get(l) > mid) {
        l++;
      }
      while (l <= r && nums.get(r) < mid) {
        r--;
      }

      if (l <= r) {
        int temp = nums.get(l);
        nums.set(l, nums.get(r));
        nums.set(r, temp);
        l++;
        r--;
      }
    }

    if (r + 1 >= k) {
      quickSelect(k, nums, left, r);
    }
    if (l + 1 <= k) {
      quickSelect(k, nums, l, right);
    }

    return nums.get(k - 1);
  }
};
