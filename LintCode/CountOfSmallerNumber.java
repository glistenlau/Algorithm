// Solution 1: Sort and Binary Search
public class Solution {
  /**
   * @param A: An integer array
   * @return: The number of element in the array that
   *          are smaller that the given integer
   */
  public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
    // write your code here

    Arrays.sort(A);

    ArrayList<Integer> result = new ArrayList<Integer>();
    for (int query: queries) {
      result.add(findPos(A, query));
    }

    return result;
  }

  private int findPos(int[] A, int tar) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int left = 0;
    int right = A.length - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A[mid] >= tar) {
        right = mid;
      } else if (A[mid] < tar) {
        left = mid;
      }
    }

    if (A[left] >= tar) {
      return left;
    }
    if (A[right] >= tar) {
      return right;
    } else {
      return right + 1;
    }
  }
}

