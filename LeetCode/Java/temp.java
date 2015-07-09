import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  /**
   * @param head: The head of linked list
   */
  public int totalNQueens(int n) {
    if (n == 0) {
      return 0;
    }
    return countNQueens(n, new int[n], 0);
  }

  public int countNQueens(int n, int[] prePos, int pos) {
    if (pos == n) {
      return 1;
    }
    int result = 0;
    for( int j = 0; j < n; j++) {
      if (!valid(prePos, pos, j)) {
        continue;
      } else {
        prePos[pos] = j;
        result += countNQueens(n, prePos, pos + 1);
      }
    }
    return result;
  }

  private boolean valid(int[] prePos, int end, int target) {
    for (int i = 0; i < end; i++) {
      if (target == prePos[i]) {
        return false;
      }
      if (Math.abs(end - i) == Math.abs(target - prePos[i])) {
        return false;
      }
    }
    return true;

  }


  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {1, 2, 3, 4};
    int result = new temp().totalNQueens(4);
    System.out.println(result);
  }
}

