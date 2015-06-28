/**
 * Climbing Stairs
 * http://www.lintcode.com/en/problem/climbing-stairs/
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 *
 * Example
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 */
public class Solution {
  /**
   * @param n: An integer
   * @return: An integer
   */
  public int climbStairs(int n) {
    // write your code here
    int cur = 0;
    int last = 1;
    int lastlast = 0;
    for (int i = 0; i < n; i++) {
      cur = last + lastlast;
      lastlast = last;
      last = cur;
    }
    return cur;
  }
}