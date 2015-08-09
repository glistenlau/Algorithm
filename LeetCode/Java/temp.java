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
          map.remove(newStr);
          taken.add(newStr);
          dfs(newStr, end, map, result, minS, taken);
          taken.remove(taken.size() - 1);
        }
      }
      curt[i] = pre;
    }
  }






  public static void main(String[] args) {
    String[] temp = {"hot","dot","dog","lot","log"};

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }
    char[][] sodoku = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
    int[] A = {8,3,6,2,8,8,8,4,2,0,7,2,9,4,9};
    int[][] matrix1 = {{1, 2, 3, 6, 5}, {16, 41, 23, 22, 6}, {15, 17, 24, 21, 7}, {14, 18, 19, 20, 10}, {13, 14, 11, 10, 9}};

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    TreeLinkNode tln = new TreeLinkNode(1);
    tln.left = new TreeLinkNode(2);
    tln.right = new TreeLinkNode(3);
    tln.left.left = new TreeLinkNode(4);
    tln.left.right = new TreeLinkNode(5);
    tln.right.right = new TreeLinkNode(7);


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
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    boolean check = dict.contains("hot");
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int[] pre = {1, 2, 5, 6, 3, 7, 8};
    int[] in = {5, 2, 6, 1, 7, 3, 8};
    int[] post = {5, 6, 2, 7, 8, 3, 1};
    new temp().findLadders("hit", "cog", dict);


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

