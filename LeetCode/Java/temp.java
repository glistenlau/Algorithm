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
  public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<String>();

    helper(result, "", n, n);
    return result;
  }

  private void helper(List<String> result, String s, int left, int right) {
    if (left > right || left < 0 || right < 0) {
      return;
    }

    if (left == 0 && right == 0) {
      result.add(s);
    }

    helper(result, s + "(", left - 1, right);
    helper(result, s + ")", left, right - 1);
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
    int[] A = {-1,-2,-3,-100,-1,-50};

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    List<String> result = new temp().generateParenthesis(3);
    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

