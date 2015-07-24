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
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }

    int length = matrix.length;

    for (int i = 0; i < length / 2; i++) {
      for (int j = 0; j < (length + 1) / 2; j++){
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[length - j - 1][i];
        matrix[length -j - 1][i] = matrix[length - i - 1][length - j - 1];
        matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
        matrix[j][length - i - 1] = tmp;
      }
    }
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
    int[] A = {3,3,0,0,2,3,2};
    int[][] matrix1 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

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
    new temp().rotate(matrix1);
//    System.out.println(new temp().rotate(matrix1));


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

