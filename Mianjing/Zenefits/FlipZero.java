/**
 * You are given a binary array with N elements: d[0], d[1], … d[N - 1].
 * You can perform AT MOST one move on the array: choose any two integers [L, R], and flip all the elements between (and including) the L-th and R-th bits. L and R
 * represent the left-most and right-most index of the bits marking the boundaries of the segment which you have decided to flip.
 *
 * What is the maximum number of '1'-bits (indicated by S) which you can obtain in the final bit-string?
 *
 * 'Flipping' a bit means, that a 0 is transformed to a 1 and a 1 is transformed to a 0 Input
 * Formal An integer N
 *
 * Next line contains the N bits, separated by spaces: d[0] d[1] … d[N - 1]
 *
 * Output:
 * S
 *
 * Sample Input:
 *
 * 8
 * 1 0 0 1 0 0 1
 *
 * Sample Output:
 * 6
 */
public class FlipZero {
  public int flipZero(int[] arr) {
    if (arr == null || arr.length == 0) {
      return 0;
    }

    int one = 0;
    int zero = 0;
    int max = -1;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        zero = Math.max(1, zero + 1);
        max = Math.max(max, zero);
      } else {
        one++;
        zero--;
      }
    }

    return one + max;
  }

  public static void main(String[] args) {
    System.out.println(new FlipZero().flipZero(new int[]{1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0}));
  }
}
