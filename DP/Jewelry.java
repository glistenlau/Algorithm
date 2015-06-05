import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by YiLIU on 6/2/15.
 */
public class Jewelry {
  public long zeroOnePack (int volum, int[] weights, int[] values) {
    int n = weights.length;
    int[] d = new int[volum + 1];
    Arrays.fill(d, 1, volum + 1, Integer.MIN_VALUE);

    for (int i = 0; i < n; ++i) {
      for (int j = volum; j >= weights[i]; --j) {
          d[j] = Math.max(d[j], d[j - weights[i]] + values[i]);
      }
    }
    return d[volum];
 }

  public long completePack (int volum, int[] weights, int[] values) {
    int n = weights.length;
    int[] d = new int[volum + 1];

    for (int i = 0; i < n; ++i) {
      for (int j = weights[i]; j <= volum; ++j) {
        d[j] = Math.max(d[j], d[j - weights[i]] + values[i]);
      }
    }
    return d[volum];
  }

  public long multiplePack (int volum, int[] num, int[] weights, int[] values) {
    int n = weights.length;
    int[] d = new int[volum + 1];
    for (int i = 0; i < n; ++i) {
      if (weights[i] * num[i] >= volum) {
        for (int j = weights[i]; j <= volum; ++j) {
          d[j] = Math.max(d[j], d[j - weights[i]] + values[i]);
        }
        continue;
      }

      int k = 1;
      while (k < num[i]) {
        for (int j = volum; j >= k * weights[i]; --j) {
          d[j] = Math.max(d[j], d[j - k * weights[i]] + k * values[i]);
        }
        num[i] -= k;
        k *= 2;
      }
      for (int j = volum; j >= num[i] * weights[i]; --j) {
        d[j] =Math.max(d[j], d[j - num[i] * weights[i]] + num[i] * values[i]);
      }
    }
    return d[volum];
  }

  public static void main(String[] args) {
    int volum = 10;
    int[] weights = {4, 3, 5, 2, 5};
    int[] values = {9, 6, 1, 4, 1};
    int[] nums = {1, 3, 3, 3, 3};
    System.out.println(new Jewelry().zeroOnePack(volum, weights, values));
    System.out.println(new Jewelry().completePack(volum, weights, values));
    System.out.println(new Jewelry().multiplePack(volum, nums, weights,
        values));
  }
}
