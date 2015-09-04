public class Solution {
  String[] upTo19 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

  String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

  String[] levels = {"", "Thousand", "Million", "Billion", "Trillion"};

  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }

    int level = 0;
    StringBuilder ans = new StringBuilder();
    while (num > 0) {
      int n = num % 1000;
      if (n != 0) {
        if (ans.length() != 0) {
          ans.insert(0, " ");
        }
        ans.insert(0, getString(n, level));
      }
      num /= 1000;
      level++;
    }

    return ans.toString();
  }

  private String getString(int num, int level) {
    StringBuilder sb = new StringBuilder();
    int hundred = num / 100;
    if (hundred != 0) {
      getPattern(sb, upTo19[hundred] + " Hundred");
      num -= hundred * 100;
    }
    int ten = num / 10;
    if (ten > 1) {
      getPattern(sb, tens[ten]);
      num -= ten * 10;
      if (num != 0) {
        getPattern(sb, upTo19[num]);
      }
    } else {
      if (num != 0) {
        getPattern(sb, upTo19[num]);
      }
    }

    if (level != 0) {
      sb.append(" " + levels[level]);
    }

    return sb.toString();
  }

  private void getPattern(StringBuilder sb, String input) {
    if (sb.length() != 0) {
      sb.append(" ");
    }
    sb.append(input);
  }
}