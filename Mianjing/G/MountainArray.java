/**
 * Given a list of integers, sort them in a way that if output is s1, s2, s3 .. sN then s1 <= s2 >=s3 <=s4 ... sN.
 * 题目的要求是偶数位数字要不小于相邻的奇数位数字， 所以我们check所有的偶数位数字，如果不满足， 则和两边较大的那个交换，对于之前的数据不会有有影响，因为之前奇数位的数字都小于偶数位数字，如果交换了一个
 * 更小的数字， 前面的仍然会满足。
 */
public class MountainArray {
  public void mountainArray(int[] arr) {
    if (arr == null || arr.length < 2) {
      return;
    }

    for (int i = 1; i < arr.length; i += 2) {
      if (arr[i] < arr[i - 1]) {
        swap(arr, i, i - 1);
      }
      if (i < arr.length - 1 && arr[i] < arr[i + 1]) {
        swap(arr, i, i + 1);
      }
    }
  }

  private void swap(int[] arr, int a, int b) {
    int temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 3, 2, 4, 5, 4, 54, 6, 7, 6};
    new MountainArray().mountainArray(arr);
    System.out.print(1);
  }
}
