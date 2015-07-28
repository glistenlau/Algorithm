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
  public void setZeroes(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return;
    }
    boolean[] row = new boolean[matrix.length];
    boolean[] col = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      if (row[i]) {
        continue;
      }
      for (int j = 0; j < matrix[0].length; j++) {
        if (col[j]) {
          continue;
        }
        if (matrix[i][j] == 0) {
          row[i] = true;
          col[j] = true;
          zeroRow(matrix, i, row, col);
          zeroCol(matrix, j, row, col);
          break;
        }
      }
    }
  }

  private void zeroCol(int[][] matrix, int col, boolean[] setRow, boolean[] setCol) {
    for (int i = 0; i < matrix.length; i++) {
      if (setRow[i]) {
        continue;
      }
      if(matrix[i][col] == 0) {
        setRow[i] = true;
        zeroRow(matrix, i, setRow, setCol);
      }
    }
    for (int i = 0; i < matrix.length; i++) {
      matrix[i][col] = 0;
    }
  }

  private void zeroRow(int[][] matrix, int row, boolean[] setRow, boolean[] setCol) {
    for (int j = 0; j < matrix[row].length; j++) {
      if (setCol[j]) {
        continue;
      }
      if (matrix[row][j] == 0) {
        setCol[j] = true;
        zeroCol(matrix, j, setRow, setCol);
      }
    }
    for (int j = 0; j < matrix[row].length; j++) {
      matrix[row][j] = 0;
    }
  }






  public static void main(String[] args) {
    String[] temp = {"dissenter","residents","overturns","turnovers"};
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
    int[] A = {3,3,0,0,2,3,2};
    int[][] matrix1 = {{0, 0, 0, 5}, {4, 3, 1, 4}, {0, 1, 1, 4}, {1, 2, 1, 3}, {0, 0, 1, 1}};

    List<Interval> test = new ArrayList<>();
    test.add(new Interval(1, 2));
    test.add(new Interval(3, 5));
    test.add(new Interval(6, 7));
    test.add(new Interval(8, 10));
    test.add(new Interval(12, 16));
    Queue<Set<String>> myQueue = new LinkedList<>();
    myQueue.add(dict);
    dict.remove("hot");

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
    new temp().setZeroes(matrix1);


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

