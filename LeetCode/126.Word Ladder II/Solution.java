public class Solution {
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    List<List<String>> result = new ArrayList<List<String>>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    int minStep = buildMap(start, end, dict, map);
    if (minStep == 0) {
      return result;
    }
    List<String> taken = new ArrayList<String>();
    taken.add(start);
    dfs(start, end, map, result, minStep, taken);
    return result;
  }

  private int buildMap(String start, String end, Set<String> dict, HashMap<String, Integer> map) {
    Queue<String> myQ = new LinkedList<String>();
    myQ.offer(end);
    dict.remove(end);
    int len = 1;
    while(!myQ.isEmpty()) {
      int size = myQ.size();
      for (int i = 0; i < size; i++) {
        char[] curt = myQ.poll().toCharArray();
        for (int j = 0; j < curt.length; j++) {
          char pre = curt[j];
          for (char c = 'a'; c <= 'z'; c++) {
            curt[j] = c;
            String newStr = new String(curt);
            if (newStr.equals(start)) {
              return len + 1;
            }
            if (dict.contains(newStr)) {
              myQ.offer(newStr);
              map.put(newStr, len + 1);
              dict.remove(newStr);
            }
          }
          curt[j] = pre;
        }
      }
      len++;
    }
    return 0;
  }

  private void dfs(String start, String end, HashMap<String, Integer> map, List<List<String>> result, int minS, List<String> taken) {
    int n = taken.size();
    if (n == minS) {
      return;
    }

    char[] curt = start.toCharArray();
    for (int i = 0; i < curt.length; i++) {
      char pre = curt[i];
      for (char c = 'a'; c <= 'z'; c++) {
        curt[i] = c;
        String newStr = new String(curt);
        if (newStr.equals(end)) {
          taken.add(end);
          result.add(new ArrayList<String>(taken));
          taken.remove(taken.size() - 1);
          return;
        }
        if (map.containsKey(newStr) && map.get(newStr) == minS - n) {
          taken.add(newStr);
          dfs(newStr, end, map, result, minS, taken);
          taken.remove(taken.size() - 1);
        }
      }
      curt[i] = pre;
    }
  }
}