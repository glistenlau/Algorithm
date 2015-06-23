/**
 * Created by YiLIU on 6/21/15.
 */
public class MergeSortedArray {
  public void mergeSortedArray(int[] A, int m, int[] B, int n) {
    int i = m-1, j = n-1, index = m + n - 1;
    while (i >= 0 && j >= 0) {
      if (A[i] > B[j]) {
        A[index--] = A[i--];
      } else {
        A[index--] = B[j--];
      }
    }
    while (i >= 0) {
      A[index--] = A[i--];
    }
    while (j >= 0) {
      A[index--] = B[j--];
    }
  }

  public static void main(String[] args) {
    int A[] = {1, 3, 4, 6, 0, 0};
    int B[] = {2, 5};
    new MergeSortedArray().mergeSortedArray(A, 4, B, 2);
    System.out.println(A);
  }
}
