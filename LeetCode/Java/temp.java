import java.util.ArrayList;
import java.util.List;

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
  public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
      // write your code here
      List<List<String>> result = new ArrayList<>();
      if (s == null || s.length() == 0) {
        return result;
      }
      helper(s, 0, new ArrayList<String>(), result);
      return result;
    }

    private void helper(String s, int start, List<String> taken, List<List<String>> result) {
      if (start == s.length() + 1) {
        result.add(new ArrayList<String>(taken));
        return;
      }
      for (int i = start + 1; i <= s.length(); i++) {
        if (!isPalindrome(s.substring(start, i))) {
          continue;
        }
        taken.add(s.substring(start, i));
        helper(s, i, taken, result);
        taken.remove(taken.size() - 1);
      }
    }

    private boolean isPalindrome(String s) {
      int left = 0;
      int right = s.length() - 1;
      while(left < right) {
        if (s.charAt(left) != s.charAt(right)) {
          return false;
        }
        left += 1;
        right -= 1;
      }
      return true;
    }
  }


  public static void main(String[] args) {
    ListNode test = new ListNode(Integer.MIN_VALUE).serilization("21->25->25->31->4");
    ListNode result = new temp().sortList(test);
    return;
  }
}

