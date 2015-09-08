/**
 * Plus One
 * www.lintcode.com/en/problem/plus-one/
 *
 * Given a non-negtive number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
  /**
   * @param digits a number represented as an array of digits
   * @return the result
   */
  public int[] plusOne(int[] digits) {
    // Write your code here
    if (digits == null || digits.length == 0) {
      return new int[0];
    }
    int carry = 1;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (carry == 0) {
        break;
      }
      int sum = digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
    }

    if (carry != 0) {
      digits = resize(digits);
      digits[0] = carry;
    }
    return digits;
  }

  private int[] resize(int[] digits) {
    int[] ans = new int[digits.length + 1];
    for (int i = digits.length - 1; i >= 0; i--) {
      ans[i + 1] = digits[i];
    }
    return ans;
  }
}
