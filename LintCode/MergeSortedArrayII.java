/**
 * Merge Sorted Array II
 * http://www.lintcode.com/en/problem/merge-sorted-array-ii/
 *
 * Merge two given sorted integer array A and B into a new sorted integer array.
 *
 * Example
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 */
class Solution {
  /**
   * @param A and B: sorted integer array A and B.
   * @return: A new sorted integer array
   */
  public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    // write your code here
    int m = A.size() - 1;
    int n = B.size() - 1;
    while (m >= 0 && n >= 0) {
      if (A.get(m) > B.get(n)) {
        result.add(0, A.get(m--));
      } else {
        result.add(0, B.get(n--));
      }
    }
    while (m >= 0) {
      result.add(0, A.get(m--));
    }
    while (n >= 0) {
      result.add(0, B.get(n--));
    }
    return result;
  }
}