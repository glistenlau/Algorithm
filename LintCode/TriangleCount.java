/**
 * Triangle Count
 * www.lintcode.com/en/problem/triangle-count/
 *
 * Given an array of integers, how many three numbers can be found in the array, so that we can build
 * an triangle whose three edges length is the three numbers that we find?
 */
public class Solution {
  /**
   * @param S: A list of integers
   * @return: An integer
   */
  public int triangleCount(int S[]) {
    // write your code here
    if (S == null || S.length == 0) {
      return 0;
    }

    Arrays.sort(S);
    int count = 0;

    for (int i = S.length - 1; i >= 2; i--) {
      int left = 0;
      int right = i - 1;
      while (left < right) {
        int sum = S[left] + S[right];
        if (sum > S[i]) {
          count += right - left;
          right--;
        } else if (sum <= S[i]) {
          left++;
        }
      }
    }

    return count;
  }
}
