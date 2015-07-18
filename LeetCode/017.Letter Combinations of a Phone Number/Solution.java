public class Solution {
  public List<String> letterCombinarions(String digits) {
    List<String> result = new ArrayList<String>();
    if (digits == null || digits.length() == 0) {
      return result;
    }
    String[] lookup = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}

    helper(digits, 0, new StringBuilder(), result, lookup);
    return result;
  }

  private void helper(String digits, int pos, StringBuilder taken, List<String> result, String[] lookup) {
    if (taken.length() == digits.length()) {
      result.add(taken.toString());
      return;
    }
    String value = lookup[Character.getNumericValue(digits.charAt(pos))];

    for (int i = 0; i < value.length() ; i++) {
      taken.append(value.substring(i, i + 1);
      helper(digits, pos + 1, taken, result, lookup);
      taken.delete(taken.length() - 1);
    }

  }
}