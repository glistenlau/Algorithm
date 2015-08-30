public class Solution {
  public int nthUglyNumber(int n) {
    int two = 0;
    int three = 0;
    int five = 0;
    int ans = 1;
    List<Integer> ugly = new ArrayList<>();

    for (int i = 1; i < n; i++) {
      ugly.add(ans);
      int val2 = ugly.get(two) * 2;
      int val3 = ugly.get(three) * 3;
      int val5 = ugly.get(five) * 5;

      ans = Math.min(val2, Math.min(val3, val5));

      two += ans == val2? 1: 0;
      three += ans == val3? 1: 0;
      five += ans == val5? 1: 0;
    }

    return ans;
  }
}