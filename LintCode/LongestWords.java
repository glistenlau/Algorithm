/**
 * Longest Words
 * www.lintcode.com/en/problem/longest-words/
 *
 * Given a dictionary, find all of the longest words in the dictionary.
 */
class Solution {
  /**
   * @param dictionary: an array of strings
   * @return: an arraylist of strings
   */
  ArrayList<String> longestWords(String[] dictionary) {
    if (dictionary == null || dictionary.length == 0) {
      return new ArrayList<>();
    }

    ArrayList<String> ans = new ArrayList<>();
    int max = 0;
    for (int i = 0; i < dictionary.length; i++) {
      if (dictionary[i].length() > max) {
        ans = new ArrayList<>();
        max = dictionary[i].length();
      }
      if (dictionary[i].length() == max) {
        ans.add(dictionary[i]);
      }
    }

    return ans;
  }
};
