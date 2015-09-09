import com.sun.deploy.net.protocol.about.AboutURLConnection;

/**
 * 给定一个 array,只包含 0,1, 找到一个分割位置,使左侧 0 出现的个数和右侧 1 出现的个数之和最大化.
 * 这题首先想到用dp，把每个位置左边的0的个数和右边的1的个数存起来，遍历一遍得到结果。空间复杂度O（n）另外一个优化的方法是， 先遍历一遍数组把1的个数出来，然后从左往右数0，遇到1就把1就把1的count值减1，遇到0就把0的计数
 * 值加一。空间复杂度O（1）
 */
public class CountLeftZeroRightOne {
  // Solution 1:
  public int countLeftZeroRightOne(int[] arr) {
    int[] leftZero = new int[arr.length + 1];
    int[] rightOne = new int[arr.length + 1];

    for (int i = 1; i <= arr.length; i++) {
      leftZero[i] = leftZero[i - 1] + (arr[i - 1] == 0? 1: 0);
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      rightOne[i] = rightOne[i + 1] + (arr[i] == 1? 1: 0);
    }

    int max = 0;
    for (int i = 0; i <= arr.length; i++) {
      max = Math.max(leftZero[i] + rightOne[i], max);
    }

    return max;
  }

  // Solution 2:
  public int countLeftZeroRightOne2(int[] arr) {
    int one = 0;
    for (int num: arr) {
      if (num == 1) {
        one++;
      }
    }

    int ans = one;
    int zero = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        zero++;
      } else {
        one--;
      }
      ans = Math.max(zero + one, ans);
    }

    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 1, 0, 0, 1, 0, 0, 1};
    System.out.println(new CountLeftZeroRightOne().countLeftZeroRightOne2(arr));
  }
}
