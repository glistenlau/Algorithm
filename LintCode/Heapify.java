/**
 * Heapify
 * www.lintcode.com/en/problem/heapify/
 *
 * Given an integer array, heapify it into a min-heap array.
 *
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 +
 * 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 *
 * Example
 * Given [3, 2, 1, 4, 5], return [1, 2, 3, 4, 5] or any legal heap array.
 */

public class Solution {
  /**
   * @param A: Given an integer array
   * @return: void
   */
  public void heapify(int[] A) {
    if (A == null || A.length == 0) {
      return;
    }

    for (int i = 0; i < A.length; i++) {
      siftup(A, i);
    }
  }

  private void siftup(int[] nums, int index) {
    while(index != 0) {
      int root = 0;
      if (index % 2 == 0) {
        root = (index - 2) / 2;
      } else {
        root = (index - 1) / 2;
      }
      if (nums[index] < nums[root]) {
        int temp = nums[index];
        nums[index] = nums[root];
        nums[root] = temp;
        index = root;
      } else {
        return;
      }
    }
  }
}
