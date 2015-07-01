/**
 * Anagrams
 * http://www.lintcode.com/en/problem/anagrams/
 *
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Example
 * Given ["lint", "intl", "init", "code"], return ["lint", "init", "intl"].
 * Given ["ab", "ba", "cd", "dc", "e"], return ["ab", "ba", "cd", "dc"].
 */
public class Solution {
  /**
   * @param strs: A list of strings
   * @return: A list of strings
   */
  public List<String> anagrams(String[] strs) {
    // write your code here
    List<String> result = new ArrayList<String>();
    if (strs == null || strs.length == 0) {
      return result;
    }
    int i = 0;
    HashSet<Integer> lookup = new HashSet<Integer>();
    while (i < strs.length) {
      if (lookup.contains(i)) {
        i++;
        continue;
      }
      List<String> temp = new ArrayList<String>();
      temp.add(strs[i]);
      lookup.add(i);
      int j = 0;
      while (j < strs.length) {
        if (lookup.contains(j)){
          j++;
          continue;
        }
        if(isAnagrams(strs[i], strs[j])) {
          temp.add(strs[j]);
          lookup.add(j);
        }
        j++;
      }
      if (temp.size() > 1) {
        result.addAll(temp);
      } else {
        lookup.remove(i);
      }
      i++;
    }
    return result;
  }

  private boolean isAnagrams(String A, String B) {
    if (A.length() != B.length()) {
      return false;
    }
    int[] lookup = new int[256];
    for (int i = 0; i < A.length(); i++) {
      lookup[A.charAt(i)] += 1;
    }
    for (int i = 0; i < B.length(); i++) {
      if (--lookup[B.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }
}
