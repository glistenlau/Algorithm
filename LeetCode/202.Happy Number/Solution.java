public class Solution {
  public boolean isHappy(int n) {
    return isHappy(n, new HashSet<>());
  }

  private boolean isHappy(int n, HashSet<Integer> got) {
    if (got.contains(n)) {
      return false;
    }

    got.add(n);
    int sum = 0;

    while (n > 0) {
      sum += (n % 10) * (n % 10);
      n /= 10;
    }

    if (sum == 1) {
      return true;
    } else {
      return isHappy(sum, got);
    }

  }
}