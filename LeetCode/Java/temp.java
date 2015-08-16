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
  /**
   * @param n an integer
   * @param m an integer
   * @param operators an array of point
   * @return an integer array
   */
  public List<Integer> numIslands2(int n, int m, Point[] operators) {
    // Write your code here
    List<Integer> result = new ArrayList<Integer>();
    UnionFind uf = new UnionFind(n, m);
    int[][] matrix = new int[n][m];
    int[] rowOffset = {-1, 1, 0, 0};
    int[] colOffset = {0, 0, -1, 1};
    int count = 0;

    for (Point p: operators) {
      matrix[p.x][p.y] = 1;
      for (int i = 0; i < 4; i++) {
        int row = p.x + rowOffset[i];
        int col = p.y + colOffset[i];
        if (row >= 0 && row < n && col >= 0 && col < m && matrix[row][col] == 1) {
          if (uf.compressedFind(p.x * m + p.y) != uf.compressedFind(row * m + col)) {
            uf.union(p.x * m + p.y, row * m + col);
            count--;
          }
        }
      }
      result.add(++count);
    }

    return result;
  }

  private class UnionFind {
    int[] fathers;

    UnionFind(int row, int col) {
      fathers = new int[row * col];
      for (int i = 0; i < fathers.length; i++) {
        fathers[i] = i;
      }
    }

    int compressedFind(int pos) {
      int father = fathers[pos];
      while (father != fathers[father]) {
        father = fathers[father];
      }

      int fa = fathers[pos];
      while (fa != fathers[fa]) {
        int temp = fathers[fa];
        fathers[fa] = father;
        fa = temp;
      }

      return father;
    }

    void union(int a, int b) {
      int aFa = compressedFind(a);
      int bFa = compressedFind(b);
      if (aFa != bFa) {
        fathers[bFa] = aFa;
      }
    }
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
    Point[] pts= {new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};

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
    new temp().numIslands2(3, 3, pts);


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

