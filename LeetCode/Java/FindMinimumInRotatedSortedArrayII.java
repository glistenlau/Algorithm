/**
 * Created by YiLIU on 6/21/15.
 */
public class FindMinimumInRotatedSortedArrayII {
  public int findMin(int[] num) {
    // write your code here
    if (num == null || num.length == 0) {
      return Integer.MIN_VALUE;
    }
    int min = num[0];
    for (int i = 0; i < num.length; ++i) {
      min = num[i] < min ? num[i] : min;
    }
    return min;
  }
}
