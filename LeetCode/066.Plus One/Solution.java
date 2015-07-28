public class Solution {
  public int[] plusOne(int[] digits) {
    int[] result = null;
    if (digits == null || digits.length == 0) {
      return null;
    }

    int sum = 0;
    int carry = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      sum = i == digits.length - 1? digits[i] + 1: digits[i] + carry;
      digits[i] = sum % 10;
      carry = sum / 10;
    }

    if (carry != 0) {
      result = new int[digits.length + 1];
      result[0] = carry;
      for (int i = 1; i <= digits.length; i++) {
        result[i] = digits[i - 1];
      }
    }

    return carry != 0? result: digits;
  }
}