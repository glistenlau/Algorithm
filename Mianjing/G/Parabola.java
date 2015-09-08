/**
 * 给定双曲线方程y = a* x * x + b * x + c和一个排好序的数组，求输出一个数组，包含所有y的排序后的值.
 * 由于是排好序的数组，很自然想到二分搜索， 因为抛物线是以 -b/2a 对称的，找到离这点最近的两个点，根据
 * 其和对称轴的距离大小输出就可以了， 要注意一些边际情况。
 */
public class Parabola {
  public int[] parabola(int[] arr, int a, int b, int c) {
    if (arr == null || arr.length == 0) {
      return new int[0];
    }
    int[] ans = new int[arr.length];

    if (a == 0) {
      for (int i = 0; i < arr.length; i++) {
        ans[i] = getParabola(arr[i], 0, b, c);
      }
      if (b < 0) {
        reverse(ans);
      }
    } else {
      int axis = (-b) / (2 * a);
      int left = 0;
      int right = arr.length - 1;
      while (left + 1 < right) {
        int mid = left + (right - left) / 2;
        if (arr[mid] <= axis) {
          left = mid;
        } else {
          right = mid;
        }
      }

      fillArray(arr, ans, left, right, axis, a, b, c);
      if (a < 0) {
        reverse(ans);
      }
    }
    return ans;
  }

  private void fillArray(int[] ori, int[] ans, int left, int right, int axis, int a, int b, int c) {
    int index = 0;
    while (left >= 0 && right < ori.length) {
      if (Math.abs(ori[left] - axis) < Math.abs(ori[right] - axis)) {
        ans[index++] = getParabola(ori[left--], a, b, c);
      } else {
        ans[index++] = getParabola(ori[right++], a, b, c);
      }
    }

    while (left >= 0) {
      ans[index++] = getParabola(ori[left--], a, b, c);
    }

    while (right < ori.length) {
      ans[index++] = getParabola(ori[right++], a, b, c);
    }
  }

  private int getParabola(int x, int a, int b, int c) {
    return (int)((long)a * x * x + b * x + c);
  }

  private void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int temp = arr[left];
      arr[left++] = arr[right];
      arr[right--] = temp;
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6};
    int[] ans = new Parabola().parabola(arr, 0, -4, 6);
    for (int num: ans) {
      System.out.println(num);
    }
  }
}
