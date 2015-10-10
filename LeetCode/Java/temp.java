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
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }
    if (grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    int count = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == '1') {
          bfs(grid, r, c);
          count++;
        }
      }
    }

    return count;
  }

  private void bfs(char[][] grid, int r, int c) {
    Queue<Integer> myQ = new LinkedList<>();
    myQ.offer(r * grid[0].length + c);
    int[] dx = {0, 0, -1, 1};
    int[] dy = {1, -1, 0, 0};

    while (!myQ.isEmpty()) {
      int cur = myQ.poll();
      int row = cur / grid[0].length;
      int col = cur % grid[0].length;
      grid[row][col] = '2';
      for (int i = 0; i < 4; i++) {
        int nr = row + dx[i];
        int nc = col + dy[i];

        if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length) {
          if (grid[nr][nc] == '1') {
            myQ.offer(nr * grid[0].length + nc);
          }
        }
      }
    }

  }






  public static void main(String[] args) {
    String[] temp = {"oath", "pea", "eat", "rain"};
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'o', 'f', 'l', 'v'}
    };

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"1 + 1", " 2-1 + 2", "(1 + (4+5+2)-3) + (6+8)"};
    int i = 0;


    char[][] sodoku = {{'1', '1', '1', '0'},
        {'1', '1', '0', '1'},
        {'1', '1', '0', '0'},
        {'0', '0', '0', '0'}};
    int[] A = {3, 2, 1, 3, 3, 3, 5, 6, 3, 7};
    int[] BB = {5, 6, 7, 3, 2, 1, 0};
    int[][] matrix1 = {{1,1,1,1,1,1,1,1,1,1,1,-10,1,1,1,1,1,1,1,1,1,1,1}};

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);



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
//
//    ListNode head = new ListNode(4);
//    head.next = new ListNode(3);
//    head.next.next = new ListNode(1);
//    head.next.next.next = new ListNode(5);
//    head.next.next.next.next = new ListNode(2);
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

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);

    for (int offset = 0; offset < 9; offset++) {
      System.out.println(new temp().numIslands(sodoku));
    }

  }
}

