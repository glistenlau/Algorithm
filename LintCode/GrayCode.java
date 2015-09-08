/**
 * Gray Code
 * www.lintcode.com/en/problem/gray-code/
 *
 * The gray code is a binary numeral system where two successive values differ in only one
 * bit.
 *
 * Given a non-negtive integer n representing the total number of bits in the code, find the
 * sequence of gray code. A gray code sequence must begin with 0 ans with cover all 2^n integers.
 */
public class Solution {
  /**
   * @param n a number
   * @return Gray code
   */
  public ArrayList<Integer> grayCode(int n) {
    // Write your code here
    if (n == 0) {
      return new ArrayList<>(Arrays.asList(0));
    }
    ArrayList<Integer> ans = grayCode(n - 1);
    int num = 1 << (n - 1);
    for (int i = ans.size() - 1; i >= 0; i--) {
      ans.add(ans.get(i) + num);
    }
    return ans;
  }
}
