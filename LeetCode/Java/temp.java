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
  public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<>();
    if (A == null || A.length == 0) {
      return result;
    }

    SegmentTreeNode root = buildTree(0, 10000);
    for (int num: A) {
      result.add(query(root, 0, num - 1));
      addToTree(root, num);
    }

    return result;
  }

  private class SegmentTreeNode {
    int start, end, count;
    SegmentTreeNode left, right;
    SegmentTreeNode(int start, int end) {
      count = 0;
      this.start = start;
      this.end = end;
      left = right = null;
    }
  }

  private SegmentTreeNode buildTree(int start, int end) {
    SegmentTreeNode root = new SegmentTreeNode(start, end);
    if (start == end) {
      return root;
    }

    int mid = start + (end - start) / 2;
    root.left = buildTree(start, mid);
    root.right = buildTree(mid + 1, end);
    return root;
  }

  private int query(SegmentTreeNode root, int start, int end) {
    if (start <= root.start && end >= root.end) {
      return root.count;
    }

    int mid = root.start + (root.end - root.start) / 2;
    int left = 0;
    int right = 0;
    if (start <= mid) {
      if (end > mid) {
        left = query(root.left, start, mid);
      } else {
        left = query(root.left, start, end);
      }
    }
    if (end > mid) {
      if (start <= mid) {
        right = query(root.right, mid + 1, end);
      } else {
        right = query(root.right, start, end);
      }
    }

    return left + right;
  }

  private void addToTree(SegmentTreeNode root, int num) {
    if (root.start == root.end && root.start == num) {
      root.count = 1;
      return;
    }

    int mid = root.start + (root.end - root.start) / 2;
    if (num <= mid) {
      addToTree(root.left, num);
    } else {
      addToTree(root.right, num);
    }
    root.count += 1;
  }

  public static void main(String[] args) {
    String[] temp = {"2", "1", "+", "3", "*"};

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
    new temp().compareVersion("1.0", "1.1");


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

