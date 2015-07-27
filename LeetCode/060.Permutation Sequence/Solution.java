public class Solution {
  public String getPermutation(int n, int k) {
    StringBuilder result = new StringBuilder();
    int factorial = 1;
    int temp = n - 1;
    boolean[] taken = new boolean[n];

    for (int i = 1; i < n; i++) {
      factorial *= i;
    }

    while(factorial > 0) {
      int num = (k - 1) / factorial;
      k -= num * factorial;

      for (int i = 0; i < n; i++) {
        if (taken[i]) {
          continue;
        }
        if (num == 0) {
          result.append(i + 1);
          taken[i] = true;
        }
        num--;
      }

      factorial = temp == 0? 0 : factorial / temp;
      temp--;
    }

    return result.toString();
  }
}