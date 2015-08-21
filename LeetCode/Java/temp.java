import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  public String minWindow(String source, String target) {
    if (source == null || target == null || source.length() < target.length()) {
      return "";
    }

    HashMap<Character, Integer> tar = new HashMap<>();
    getStringMap(target, tar);
    int n = target.length();
    int left = 0;
    String ans = null;

    for (int right = 0; right < source.length(); right++) {
      char cur = source.charAt(right);
      if (tar.containsKey(cur)) {
        if (tar.get(cur) > 0) {
          n--;
        }
        tar.put(cur, tar.get(cur) - 1);
      }

      while (n <= 0) {
        if (ans == null || ans.length() > right - left + 1) {
          ans = source.substring(left, right + 1);
        }

        char r = source.charAt(left);
        if (tar.containsKey(r)) {
          if (tar.get(r) >= 0) {
            n++;
          }
          tar.put(r, tar.get(r) + 1);
        }
      }
    }
    return ans;
  }

  private void getStringMap(String s, HashMap<Character, Integer> map) {
    for (int i = 0; i < s.length(); i++) {
      char cur = s.charAt(i);
      if (!map.containsKey(cur)) {
        map.put(cur, 0);
      }

      map.put(cur, map.get(cur) + 1);
    }

  }

  public static void main(String[] args) {
    String[] temp = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"O"};
    char[][] board = new char[strA.length][strA[0].length()];
    int i = 0;
    for (String str: strA) {
      board[i++] = str.toCharArray();
    }

    char[][] sodoku = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    int[] A = {1, 2, 7, 7, 2, 10, 3, 4, 5};
    int[][] matrix1 = {{12,13,0,12},{13,4,13,12},{13,8,10,12},{12,13,12,12},{13,13,13,13}};

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//    root.right.right = new TreeNode(6);
//    TreeLinkNode tln = new TreeLinkNode(1);
//    tln.left = new TreeLinkNode(2);
//    tln.right = new TreeLinkNode(3);
//    tln.left.left = new TreeLinkNode(4);
//    tln.left.right = new TreeLinkNode(5);
//    tln.right.right = new TreeLinkNode(7);


    List<Interval> test = new ArrayList<>();
    test.add(new Interval(1, 2));
    test.add(new Interval(3, 5));
    test.add(new Interval(6, 7));
    test.add(new Interval(8, 10));
    test.add(new Interval(12, 16));
    Queue<Set<String>> myQueue = new LinkedList<>();

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
//    Point[] pts= {new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};

    ListNode head = new ListNode(4);
    head.next = new ListNode(3);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(2);
    boolean check = dict.contains("hot");
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int[] pre = {1, 2, 5, 6, 3, 7, 8};
    int[] in = {5, 2, 6, 1, 7, 3, 8};
    int[] post = {5, 6, 2, 7, 8, 3, 1};
    ArrayList<Interval> quries = new ArrayList<>();
    quries.add(new Interval(1, 2));
    quries.add(new Interval(0, 4));
    quries.add(new Interval(2, 4));
    int[] col = new int[1000];
//    System.out.println(new temp().medianSlidingWindow(A, 2));

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

