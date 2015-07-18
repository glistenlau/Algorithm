public class Solution {
  public String intToRoman(int num) {
    int[] integer = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    HashMap<Integer, String> lookup = new HashMap<Integer, String>();

    for (int i = 0; i < integer.length; i++) {
      lookup.put(integer[i], roman[i]);
    }

    int d = 1000;
    String result = "";

    while(num > 0) {
      int digit = num / d;
      num -= digit * d;
      if (digit <= 3) {
        for (int i = 0; i < digit; i++) {
          result += lookup.get(d);
        }
      } else {
        if (lookup.containsKey(digit * d)) {
          result += lookup.get(digit * d);
        } else {
          result += lookup.get(5 * d);
          digit -= 5;
          for (int i = 0; i < digit; i++) {
            result += lookup.get(d);
          }
        }
      }
      d /= 10;
    }

    return result;
  }
}