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
  public class LRUCache {
    private class DoublyListNode {
      int value;
      DoublyListNode prev, next;
      DoublyListNode(int value) {
        this.value = value;
        this.prev = this.next = null;
      }
    }

    DoublyListNode start, end;
    HashMap<Integer, DoublyListNode> map;

    public LRUCache(int capacity) {
      map = new HashMap<>();
      start = end = new DoublyListNode(capacity);
      start.next = end;
      end.prev = start;
    }

    public int get(int key) {
      if (!map.containsKey(key)) {
        return -1;
      }
      DoublyListNode curt = map.get(key);
      curt.prev.next = curt.next;
      curt.next.prev = curt.prev;
      insertToEnd(curt);
      return curt.value;
    }

    public void set(int key, int value) {
      if (map.containsKey(key)) {
        this.get(key);
        return;
      }

      if (start.value <= 0) {
        DoublyListNode least = start.next;
        start.next = least.next;
        least.next.prev = start;
        least.next = least.prev = null;
      } else {
        start.value--;
      }
      DoublyListNode newNode = new DoublyListNode(value);
      insertToEnd(newNode);
      map.put(key, newNode);
    }

    private void insertToEnd(DoublyListNode node) {
      if (node.next == end) {
        return;
      }
      node.prev = end.prev;
      node.next = end;
      end.prev.next = node;
      end.prev = node;
    }
  }




  public static void main(String[] args) {
    String[] temp = {"cat", "cats", "and", "sand", "dog"};

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
    int[] A = {1, 2, 7, 8, 5};
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
    new temp().wordBreak("catsanddog", dict);


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

