public class Solution {
  public List<String> anagrams(String[] strs) {
    List<String> result = new ArrayList<String>();
    if (strs == null || strs.length == 0) {
      return result;
    }

    HashMap<Integer, List<String>> myMap = new HashMap<Integer, List<String>>();

    for (String str: strs) {
      int[] counts = new int[26];
      for (int i = 0 ; i < str.length(); i++) {
        counts[str.charAt(i) - 'a']++;
      }
      int hash = getHash(counts);
      if (!myMap.containsKey(hash)) {
        myMap.put(hash, new ArrayList<String>());
      }
      myMap.get(hash).add(str);
    }

    for (List<String> ana: myMap.values()) {
      if (ana.size() > 1) {
        result.addAll(ana);
      }
    }
    return result;
  }

  private int getHash(int[] counts) {
    int a = 31;
    int hash = 0;
    for (int count: counts) {
      hash = hash * a + count;
    }
    return hash;
  }
}