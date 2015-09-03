/**
 * Ugly Number
 * www.lintcode.com/en/problem/ugly-number/
 *
 * Ugly number is a number that only have factors 3, 5, 7.
 * Design an algorithm to find the kth ugly number. The first 5 ugly numbers are 3, 5, 7, 9, 15...
 *
 * Example
 * If k = 4, return 9.
 */
class Solution {
  /**
   * @param k: The number k.
   * @return: The kth prime number as description.
   */
  public long kthPrimeNumber(int k) {
    // write your code here
    if (k < 1) {
      return 0;
    }

    List<Long> list = new ArrayList<Long>();
    int three = 0;
    int five = 0;
    int seven = 0;
    list.add(1L);

    for (int i = 0; i < k; i++) {
      list.add(Math.min(3 * list.get(three), Math.min(5 * list.get(five), 7 * list.get(seven))));
      three += list.get(i + 1) == 3 * list.get(three)? 1: 0;
      five += list.get(i + 1) == 5 * list.get(five)? 1: 0;
      seven += list.get(i + 1) == 7 * list.get(seven)? 1: 0;
    }

    return list.get(k);
  }
};

