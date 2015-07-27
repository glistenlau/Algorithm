// Solution1: Hash
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


// Solution2: Sort
public class Solution {
  public List<String> anagrams(String[] strs) {
    List<String> result = new ArrayList<String>();
    if (strs == null || strs.length == 0) {
      return result;
    }

    HashMap<String, List<String>> myMap = new HashMap<String, List<String>>();

    for (String str: strs) {
      char[] chars = str.toCharArray();
      sortString(chars, 0, chars.length - 1);
      String temp = new String(chars);
      if (!myMap.containsKey(temp)) {
        myMap.put(temp, new ArrayList<String>());
      }
      myMap.get(temp).add(str);
    }

    for (List<String> list: myMap.values()) {
      if (list.size() > 1) {
        result.addAll(list);
      }
    }
    return result;
  }

  private void sortString(char[] chars, int s, int e) {
    if (s >= e) {
      return;
    }

    int mid = (e + s) / 2;
    char pivot = chars[mid];
    int left = s;
    int right = e;
    while(left <= right) {
      while (left <= right && chars[left] < pivot) {
        left++;
      }
      while (left <= right && chars[right] > pivot) {
        right--;
      }
      if (left <= right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
        left++;
        right--;
      }
    }
    sortString(chars, s, right);
    sortString(chars, left, e);
  }
}