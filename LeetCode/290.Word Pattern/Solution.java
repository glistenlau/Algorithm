public class Solution {
  public boolean wordPattern(String pattern, String str) {
    if (pattern == null || pattern.length() == 0) {
      return false;
    }
    if (str == null || str.length() == 0) {
      return false;
    }

    HashMap<Character, String> map = new HashMap<>();

    int wordIndex = 0;
    while (str.charAt(wordIndex) == ' ') {
      wordIndex++;
    }
    for (int i = 0; i < pattern.length(); i++) {
      if (wordIndex >= str.length()) {
        return false;
      }
      char p = pattern.charAt(i);
      int wordEnd = wordIndex + 1;
      while (wordEnd < str.length() && str.charAt(wordEnd) != ' ') {
        wordEnd++;
      }
      String word = str.substring(wordIndex, wordEnd);
      wordIndex = wordEnd + 1;
      if (map.containsKey(p)) {
        if (!map.get(p).equals(word)) {
          return false;
        }
      } else {
        if (map.values().contains(word)) {
          return false;
        }
        map.put(p, word);
      }
    }
    
    return wordIndex >= str.length();
  }
}
