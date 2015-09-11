import java.util.Arrays;

/**
 * Given an array of N=10^6 int32 and an int32 X, compute the exact number of triples (a, b, c) of
 * distinct elements of the array so that a + b + c <= X.
 *
 * 思路和3sum差不多，但是因为求的是个数，所以两个指针找符合条件的时候不需要两层循环， 只要遍历一遍就可以了，时间复杂度O(n^2).
 * 另外题中说array的大小是10^6, 所以可能大答案是C(10^6, 3) 约等于 2^64, 所以要用long型整数.
 */
public class ThreeSumSmaller {
  public long threeSumSmaller(int[] arr, int x) {
    Arrays.sort(arr);
    long ans = 0;
    for (int i = 0; i < arr.length - 2; i++) {
      int l = i + 1;
      for ( ; arr[l] == arr[i]; l++);
      int r = arr.length - 1;
      if (arr[r] == arr[l]) {
        break;
      }
      while (l < r) {
        long sum = arr[i] + arr[l] + arr[r];
        if (sum > x) {
          r--;
        } else {
          ans += r - l;
          l++;
          while (l < r && arr[l] == arr[l - 1]) {
            l++;
          }
          if (arr[l] == arr[r]) {
            break;
          }
        }
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1, 3, 2, 4, 3, 4, 5, 6, 4, 34};
    System.out.println(new ThreeSumSmaller().threeSumSmaller(arr, 7));
  }
}
