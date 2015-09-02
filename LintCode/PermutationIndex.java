/**
 * Permutation Index
 * www.lintcode.com/en/problem/permutation-index/
 *
 * Given a permutation which contains no repeated number, find its index in all the
 * permutations of these numbers, which are ordered in lexicographical order. The
 * index begins at 1.
 *
 * Example
 * Given[1, 2, 4], return 1.
 */
public class Solution {
  /**
   * @param A an integer array
   * @return a long integer
   */
  public long permutationIndex(int[] A) {
    // Write your code here
    if (A == null || A.length < 2) {
      return 1;
    }

    ArrayList<Integer> arr = new ArrayList<>();
    for (int num: A) {
      arr.add(num);
    }

    Collections.sort(arr);

    long index = 0;
    long level = 1;i

    for (int i = A.length - 1; i > 0; i--) {
      level *= i;
    }

    for (int num: A) {
      long i = find(arr, num);
      index += i * level;
      level /= arr.isEmpty()? 2: arr.size();
    }

    return index + 1;
  }

  private long find(ArrayList<Integer> arr, int tar) {
    int left = 0;
    int right = arr.size() - 1;

    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (arr.get(mid) == tar) {
        arr.remove(mid);
        return mid;
      } else if (arr.get(mid) > tar) {
        right = mid;
      } else {
        left = mid;
      }
    }

    if (arr.get(left) == tar) {
      arr.remove(left);
      return left;
    }
    arr.remove(right);
    return right;
  }
}
