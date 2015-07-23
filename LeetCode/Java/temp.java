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
  public boolean isMatch(String s, String p) {
    boolean[][] isMatch = new boolean[p.length() + 1][s.length() + 1];

    isMatch[0][0] = true;
    for (int i = 1; i <= p.length(); i++) {
      isMatch[i][0] = isMatch[i - 1][0] && p.charAt(i - 1) == '*';
    }

    for (int i = 1; i <= p.length(); i++) {
      for (int j = 1; j <= s.length(); j++) {
        if (p.charAt(i - 1) != '*') {
          isMatch[i][j] = isMatch[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?');
        } else {
          isMatch[i][j] = isMatch[i - 1][j] || isMatch[i][j - 1];
        }
      }
    }

    return isMatch[p.length()][s.length()];
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
    char[][] sodoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
    int a = Integer.MIN_VALUE;
    int b = -2;
    b = b >>> 1;
    a = a >> 1;
    Queue<Set<String>> myQueue = new LinkedList<>();
    myQueue.add(dict);
    dict.remove("hot");

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    ListNode head = new ListNode(1);
    boolean check = dict.contains("hot");
    head.next = new ListNode(2);
    System.out.println(new temp().isMatch("aa","a"));
    System.out.println(new temp().isMatch("aa","aa"));
    System.out.println(new temp().isMatch("aaa","aa"));
    System.out.println(new temp().isMatch("aa","*"));
    System.out.println(new temp().isMatch("aa","a*"));
    System.out.println(new temp().isMatch("aa","?*"));
    System.out.println(new temp().isMatch("aab","c*a*b"));

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

