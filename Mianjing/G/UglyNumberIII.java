import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by YiLIU on 9/28/15.
 */
public class UglyNumberIII {
  public List<Integer> uglyNumber(List<Integer> primes, int k) {
    List<Integer> ans = new ArrayList<>();
    if (primes == null || primes.size() == 0 || k == 0) {
      return ans;
    }

    int[] indexs = new int[primes.size()];
    Arrays.fill(indexs, -1);

    for (int i = 0; i < k; i++) {
      int min = getMin(primes, indexs, ans);
      ans.add(min);
      updateIndex(primes, indexs, ans, min);
    }

    return ans;
  }

  private int getMin(List<Integer> primes, int[] indexs, List<Integer> ans) {
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < primes.size(); i++) {
      int cur = indexs[i] == -1? primes.get(i): primes.get(i) * ans.get(indexs[i]);
      min = Math.min(min, cur);
    }

    return min;
  }

  private void updateIndex(List<Integer> primes, int[] indexs, List<Integer> ans, int tar) {
    for (int i = 0; i < primes.size(); i++) {
      int cur = indexs[i] == -1? primes.get(i): primes.get(i) * ans.get(indexs[i]);
      if (cur == tar) {
        indexs[i]++;
      }
    }
  }

  public static void main(String[] args) {
    List<Integer> primes = new ArrayList<>(Arrays.asList(2, 3, 5));
    System.out.println(new UglyNumberIII().uglyNumber(primes, 10));
  }

}
