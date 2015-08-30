public class Solution {
  public List<Integer> diffWaysToCompute(String input) {
    List<Integer> ans = new ArrayList<>();
    if (input == null || input.length() == 0) {
      return ans;
    }
    if (isNumber(input)) {
      ans.add(Integer.parseInt(input));
      return ans;
    }

    for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.charAt(i))) {
        List<Integer> left = diffWaysToCompute(input.substring(0, i));
        List<Integer> right = diffWaysToCompute(input.substring(i + 1, input.length()));
        for (int l: left) {
          for (int r: right) {
            if (input.charAt(i) == '+'){
              ans.add(l + r);
            } else if (input.charAt(i) == '-') {
              ans.add(l - r);
            } else {
              ans.add(l * r);
            }
          }
        }
      }
    }

    return ans;
  }

  private boolean isNumber(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (!Character.isDigit(s.charAt(i))) {
        return false;
      }
    }

    return true;
  }
}