import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  /**
   * @param head: The head of linked list
   */
  public int ladderLength(String start, String end, Set<String> dict) {
    // write your code here
    if (start == null || end == null ) {
      return -1;
    }
    if (differ(start, end) < 2) {
      return differ(start, end) + 1;
    }
    if (dict.contains(start)) {
      dict.remove(start);
    }
    int result = Integer.MAX_VALUE - 1;
    for (int i = 0; i < start.length(); i++) {
      for (char c = 'a'; c <= 'z'; c++) {
        String curt = start.substring(0, i) + Character.toString(c) + start.substring(i + 1, start.length());
        if (!dict.contains(curt)) {
          continue;
        } else {
          dict.remove(curt);
          result = Math.min(result, ladderLength(curt, end, dict) + 1);
        }
      }
    }
    return result;
  }

  private int differ(String s1, String s2) {
    if (s1.length() != s2.length()) {
      return Integer.MAX_VALUE;
    }
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if (s1.charAt(i) != s2.charAt(i)) {
        count += 1;
      }
    }
    return count;
  }


  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {1, 2, 3, 4};
    int result = new temp().ladderLength("hot",
        "dog", dict);
    System.out.println(result);
  }
}

