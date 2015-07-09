/**
 * Word Ladder
 * http://www.lintcode.com/en/problem/word-ladder/
 *
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 *   1. Only one letter can be changed at a time
 *   2. Each intermediate word must exist in the dictionary
 *
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot", "dot", "dog", "lot", "log"]
 *
 * As one shortest transformation is
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog"
 * return its length 5.
 */

public class Solution {
  /**
   * @param start, a string
   * @param end, a string
   * @param dict, a set of string
   * @return an integer
   */
  public int ladderLength(String start, String end, Set<String> dict) {
    if (dict == null || dict.size() == 0) {
      return 0;
    }
    Queue<String> myQueue = new LinkedList<String>();
    myQueue.offer(start);
    dict.remove(start);
    int length = 1;
    while (!myQueue.isEmpty()) {
      int size = myQueue.size();
      for (int i = 0; i < size; i++) {
        String curt = myQueue.poll();
        for (int j = 0; j < curt.length(); j++) {
          for (char c = 'a'; c <= 'z'; c++) {
            String replace = curt.substring(0, j) + Character.toString(c) + curt.substring(j + 1, curt.length());
            if (replace.equals(end)) {
              return length + 1;
            }
            if (!dict.contains(replace)) {
              continue;
            } else {
              myQueue.offer(replace);
              dict.remove(replace);
            }
          }
        }
      }
      length += 1;
    }
    return 0;
  }
}
