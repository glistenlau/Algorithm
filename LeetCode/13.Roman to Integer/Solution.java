public class Solution {
  public int romanToInt(String s) {
    int[] integer = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    HashMap<String, Integer> lookup = new HashMap<String, Integer>();

    for (int i = 0; i < integer.length; i++) {
      lookup.put(roman[i], integer[i]);
    }
    int result = 0;

    for (int i = 0; i < s.length(); i++) {
      if (i + 1 < s.length() && lookup.get(Character.toString(s.charAt(i))) < lookup.get(Character.toString(s.charAt(i + 1)))) {
        result += lookup.get(s.substring(i, i + 2));
        i++;
      } else {
        result += lookup.get(Character.toString(s.charAt(i)));
      }
    }

    return result;
  }
}