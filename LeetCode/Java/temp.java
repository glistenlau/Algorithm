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
  public int trapRainWater(int[][] heights) {
    // write your code here
    int result = 0;
    int m = heights.length;
    int n = heights[0].length;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Point> bound = new PriorityQueue<>(2*(m + n), ptCmp);
    for (int i = 0; i < m; i++) {
      bound.offer(new Point(i, 0, heights[i][0]));
      visited[i][0] = true;
      bound.offer(new Point(i, n - 1, heights[i][n - 1]));
      visited[i][n - 1] = true;
    }

    for (int j = 0; j < n; j++) {
      bound.offer(new Point(0, j, heights[0][j]));
      visited[0][j] = true;
      bound.offer(new Point(m - 1, j, heights[m - 1][j]));
      visited[m - 1][j] = true;
    }

    while (!bound.isEmpty()) {
      Point min = bound.poll();
      for (int i = 0; i < 4; i++) {
        int x = min.x + dx[i];
        int y = min.y + dy[i];
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
          continue;
        }
        if (heights[x][y] < min.val) {
          result += min.val - heights[x][y];
          bound.offer(new Point(x, y, min.val));
        } else {
          bound.offer(new Point(x, y, heights[x][y]));
        }
        visited[x][y] = true;
      }
    }

    return result;
  }

  private class Point {
    int x, y, val;
    Point(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }
  }

  private Comparator<Point> ptCmp = new Comparator<Point>() {
    @Override
    public int compare(Point a, Point b) {
      return a.val - b.val;
    }
  };


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
    int[] A = {142,38,100,53,22,84,168,50,194,136,111,13,47,45,151,164,126,47,106,124,183,8,87,38,91,121,102,46,82,195,53,18,11,165,61};
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
    System.out.println(new temp().trapRainWater(matrix1));

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

