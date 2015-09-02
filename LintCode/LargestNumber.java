/**
 * Largest Number
 * www.lintcode.com/en/problem/largest-number/
 *
 * Given a list of non negtive integers, arrange them such that they form the largest number.
 *
 * Example
 * Given [1, 20, 23, 4, 8], the largest formed number is 8423201.
 */
public class Solution {
  /**
   *@param num: A list of non negative integers
   *@return: A string
   */
  public String largestNumber(int[] nums) {
    // write your code here
    if (nums == null || nums.length == 0) {
      return "";
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(nums.length, numCmp);
    StringBuilder sb = new StringBuilder();
    for (int num: nums) {
      maxHeap.offer(num);
    }
    while (!maxHeap.isEmpty()) {
      if (sb.toString().equals("0") && maxHeap.peek() == 0) {
        break;
      }
      sb.append((maxHeap.poll()));
    }
    return sb.toString();
  }

  private Comparator<Integer> numCmp = new Comparator<Integer>() {
    @Override
    public int compare(Integer n1, Integer n2) {
      String str1 = String.valueOf(n1) + String.valueOf(n2);
      String str2 = String.valueOf(n2) + String.valueOf(n1);
      for (int i = 0; i < str1.length(); i++) {
        if (str1.charAt(i) != str2.charAt(i)) {
          return str2.charAt(i) - str1.charAt(i);
        }
      }

      return 0;
    }
  };
}
