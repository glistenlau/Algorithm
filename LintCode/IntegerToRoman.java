/**
 * Integer to Roman
 * www.lintcode.com/en/problem/integer-to-roman/
 *
 * Given an integer, convert it to a roman numeral. The number is guaranteed to be within the range
 * from 1 to 3999.
 *
 * Example
 * 4 -> IV
 * 12 -> XII
 * 21 -> XXI
 * 99 -> XCIX
 */
public class Solution {
  /**
   * @param n The integer
   * @return Roman representation
   */
  public String intToRoman(int n) {
    // Write your code here
    char[][] num2Roman = {{'I', 'V'}, {'X', 'L'}, {'L', 'C'}, {'D', 'M'}};
    int level = 0;
    StringBuilder ans = new StringBuilder();
    while (n > 0) {
      int r = n % 10;
      if (r == 9) {
        ans.insert(0, num2Roman[level + 1][0]);
        ans.insert(0, num2Roman[level][0]);
      } else if (r >= 5) {
        for (int i = 0; i < r - 5; i++) {
          ans.insert(0, num2Roman[level][0]);
        }
        ans.insert(0, num2Roman[level][1]);
      } else if (r == 4) {
        ans.insert(0, num2Roman[level][1]);
        ans.insert(0, num2Roman[level][0]);
      } else {
        for (int i = 0; i < r; i++) {
          ans.insert(0, num2Roman[level][0]);
        }
      }
      n /= 10;
      level++;
    }

    return ans.toString();
  }
}
