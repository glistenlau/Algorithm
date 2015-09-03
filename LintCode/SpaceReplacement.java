/**
 * Space Replacement
 * www.lintcode.com/en/problem/space-replacemnet/
 *
 * Write a method to replace all spaces in a string with %20. The string is given
 * in a characters array, you can assume it has enough space for replacement and you
 * are given the true length of the string.
 *
 * Given "Mr John Smith", length = 13.
 * The String after replacement should be "Mr%20John%20Smith".
 */
public class Solution {
  /**
   * @param string: An array of Char
   * @param length: The true length of the string
   * @return: The true length of new string
   */
  public int replaceBlank(char[] string, int length) {
    // Write your code here
    if (string == null) {
      return 0;
    }
    int count = 0;
    for (int i = 0; i < length; i++) {
      if (string[i] == ' ') {
        count++;
      }
    }

    int last = length + 2 * count;
    int index = length - 1;
    for (int  i = last - 1; i >= 0; i--) {
      if (string[index] == ' ') {
        string[i--] = '0';
        string[i--] = '2';
        string[i] = '%';
      } else {
        string[i] = string[index];
      }
      index--;
    }

    return last;
  }
}
