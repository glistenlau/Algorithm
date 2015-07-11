/**
 * Porduct of Array Exclude Itself
 * www.lintcode.com/en/problem/product-of-array-exclude-itself/
 *
 * Given an integers array A.
 * Define B[i] = A[0]*...*A[i - 1]*A[i+1]*...*A[n-1], calculate B without
 * divide operation
 *
 * Example
 * For A = [1, 2, 3], return [6, 3, 2]
 */

public class Solution {
  /**
   * @param A: Given an integers array A
   * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
   */
  public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
    ArrayList<Long> result = new ArrayList<Long>();
    if (A == null || A.size() == 0) {
      return null;
    }
    result.add(1L);
    for (int i = 1; i < A.size(); i++) {
      result.add(result.get(i - 1) * A.get(i - 1));
    }
    long temp = 1L;
    for (int i = A.size() - 1; i >= 0; i--) {
      result.set(i, result.get(i) * temp);
      temp *= A.get(i);
    }
    return result;
  }
}

