import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> result = new ArrayList<Integer>();
    if (words == null || words.length == 0) {
      return result;
    }
    int num = words[0].length();
    HashMap<String, Integer> lookup = new HashMap<String, Integer>();
    for (String str : words) {
      if (!lookup.containsKey(str)) {
        lookup.put(str, 1);
      } else {
        lookup.put(str, lookup.get(str) + 1);
      }
    }

    for (int i = 0; i <= s.length() - num * words.length; i++) {
      String curt = s.substring(i, i + num);
      if (lookup.containsKey(curt)) {
        lookup.put(curt, lookup.get(curt) - 1);
        if (helper(s, i + words[0].length(), num, lookup, words.length - 1)) {
          result.add(i);
        }
        lookup.put(curt, lookup.get(curt) + 1);
      }
    }
    return result;
  }

  private boolean helper(String s, int index, int num, HashMap<String, Integer> lookup, int count) {
    if (count == 0) {
      return true;
    }
    if (index + num > s.length()) {
      return false;
    }

    String curt = s.substring(index, index + num);
    if (lookup.containsKey(curt) && lookup.get(curt) > 0) {
      lookup.put(curt, lookup.get(curt) - 1);
      boolean isValid = helper(s, index + num, num, lookup, count - 1);
      lookup.put(curt, lookup.get(curt) + 1);
      return isValid;
    }

    return false;
  }






  public static void main(String[] args) {
    String[] temp = {"word","good","best","good"};
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {-1,-2,-3,-100,-1,-50};
    int a = Integer.MIN_VALUE;
    int b = -2;
    b = b >>> 1;
    a = a >> 1;

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    ListNode head = new ListNode(1);
    boolean check = dict.contains("hot");
    head.next = new ListNode(2);
    List<Integer> result = new temp().findSubstring("wordgoodgoodgoodbestword", temp);
    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

