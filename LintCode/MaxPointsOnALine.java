/**
 * Max Points on a Line
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example
 * Given 4 points: (1, 2), (3, 6), (0, 0), (1, 3).
 * The maximum number is 3.
 */
/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
  /**
   * @param points an array of point
   * @return an integer
   */
  ArrayList<String> longestWords(String[] dictionary) {
    if (dictionary == null || dictionary.length == 0) {
      return new ArrayList<>();
    }

    ArrayList<String> ans = new ArrayList<>();
    int max = 0;
    for (int i = 0; i < dictionary.length(); i++) {
      if (dictionary[i].length() > max) {
        ans = new ArrayList<>();
      }
      if (dictionary[i].length() == max) {
        ans.add(dictionary[i]);
      }
    }

    return ans;
  }
