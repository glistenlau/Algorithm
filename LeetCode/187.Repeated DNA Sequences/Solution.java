public class Solution {
  public List<String> findRepeatedDnaSequences(String s) {
    List<String> result = new ArrayList<String>();
    if (s == null || s.length() <= 10) {
      return result;
    }
    int left = 0;
    int right = 9;
    HashMap<String, Integer> count = new HashMap<>();

    while (right < s.length()) {
      String cur = s.substring(left, right + 1);
      if (!count.containsKey(cur)) {
        count.put(cur, 0);
      }
      count.put(cur, count.get(cur) + 1);
      left++;
      right++;
    }

    for (String str: count.keySet()) {
      if (count.get(str) > 1) {
        result.add(str);
      }
    }

    return result;
  }
}