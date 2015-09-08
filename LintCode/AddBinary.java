/**
 * Add Binary
 * www.lintcode.com/en/problem/add-binary/
 *
 * Given two binary strings, return their sum(also binary string).
 *
 * Example
 * a = 11
 * b = 1
 * return 100
 */
public class Solution {
  /**
   * @param a a number
   * @param b a number
   * @return the result
   */
  public String addBinary(String a, String b) {
    // Write your code here
    int indexA = a.length() - 1;
    int indexB = b.length() - 1;
    StringBuilder ans = new StringBuilder();
    int carry = 0;
    while (indexA >= 0 && indexB >= 0) {
      int numA = a.charAt(indexA--) == '0'? 0: 1;
      int numB = b.charAt(indexB--) == '0'? 0: 1;

      int sum = numA + numB + carry;
      ans.insert(0, sum % 2);
      carry = sum / 2;
    }

    while (indexA >= 0) {
      int numA = a.charAt(indexA--) == '0'? 0: 1;
      int sum = numA + carry;
      ans.insert(0, sum % 2);
      carry = sum / 2;
    }

    while (indexB >= 0) {
      int numB = b.charAt(indexB--) == '0'? 0: 1;
      int sum = numB + carry;
      ans.insert(0, sum % 2);
      carry = sum / 2;
    }

    if (carry != 0) {
      ans.insert(0, carry);
    }

    return ans.toString();
  }
}
