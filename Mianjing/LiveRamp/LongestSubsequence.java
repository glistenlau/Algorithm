import java.util.HashMap;

/**
 * 一个sequence，里面都是整数，求最长的subsequence的长度，使得这个subsquence的最大值和最小值相差不超过
 */
public class LongestSubsequence {
  public int longestSubsequence(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    HashMap<Integer, Integer> freq = new HashMap<>();
    int ans = 0;

    for (int num: arr) {
      if (!freq.containsKey(num)) {
        freq.put(num, 0);
      }

      freq.put(num, freq.get(num) + 1);
    }

    for (int num: freq.keySet()) {
      int max = getNum(num - 1, num, freq);
      int min = getNum(num, num + 1, freq);

      ans = Math.max(ans, Math.max(max, min));
    }

    return ans;
  }

  private int getNum(int a, int b, HashMap<Integer, Integer> freq) {
    int ans = 0;
    if (freq.containsKey(a)) {
      ans += freq.get(a);
    }
    if (freq.containsKey(b)) {
      ans += freq.get(b);
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new LongestSubsequence().longestSubsequence(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
  }

}
