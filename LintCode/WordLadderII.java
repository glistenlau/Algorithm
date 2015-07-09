/**
 * Word Ladder II
 * http://www.lintcode.com/en/problem/word-ladder-ii/
 *
 * Given two words (start and end), and dictionary, find all shortest
 * transformation sequence(s) fromm start to end, such that:
 *   1. Only one letter can be changed at a time
 *   2. Each intermediate word must exist in the dictionary
 *
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot", "dot", "dog", "lot", "log"]
 */

public class Solution {
  /**
   * @param start, a string
   * @param end, a string
   * @param dict, a set of string
   * @return a list of lists of string
   */
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    List<List<String>> result = new ArrayList<List<String>>();
    HashMap<String, Integer> lookup = buildLevel(end, start, dict);
    Stack<String> myStack = new Stack<String>();
    List<String> single = new ArrayList<String>();
    myStack.push(start);
    while(!myStack.isEmpty()) {
      String curt = myStack.pop();
      single.add(curt);
      int level = lookup.get(curt);
      for (int i = 0; i < curt.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          String replace = curt.substring(0, i) + Character.toString(c) + curt.substring(i + 1, curt.length());
          if (replace.equals(end)) {
            single.add(replace);
            result.add(new ArrayList(single));
            if (!myStack.isEmpty()) {
              for (int j = 0; j <= lookup.get(myStack.peek()); j++) {
                if (single.size() == 0) {
                  return result;
                }
                single.remove(single.size() - 1);
              }
            } else {
              return result;
            }
          }

          if (!dict.contains(replace) || !lookup.containsKey(replace) || lookup.get(replace) >= level) {
            continue;
          } else {
            myStack.push(replace);
          }
        }
      }
    }
    return result;
  }

  private HashMap<String, Integer> buildLevel(String start, String end, Set<String> dict) {
    HashMap<String, Integer> result = new HashMap<String, Integer>();
    Set<String> copy = new HashSet<String>(dict);
    Queue<String> myQueue = new LinkedList<String>();
    myQueue.offer(start);
    copy.remove(start);
    int level = 0;

    while (!myQueue.isEmpty()) {
      int size = myQueue.size();
      for (int n = 0; n < size; n++) {
        String curt = myQueue.poll();
        for (int i = 0; i < curt.length(); i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            String replace = curt.substring(0, i) + Character.toString(c) + curt.substring(i + 1, curt.length());
            if (replace.equals(end)) {
              result.put(replace, level + 1);
              return result;
            }
            if (!copy.contains(replace)) {
              continue;
            } else {
              result.put(replace, level + 1);
              myQueue.add(replace);
              copy.remove(replace);
            }
          }
        }
      }
      level += 1;
    }
    return result;
  }
}
