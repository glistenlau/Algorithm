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
  /**
   * @param head: The head of linked list
   */
  public int firstMissingPositive(int[] A) {
    if (A == null || A.length == 0) {
      return 1;
    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] > 0 && A[i] <= A.length) {
        if (A[i] != i + 1) {
          int temp = A[A[i] - 1];
          A[A[i] - 1] = A[i];
          A[i] = temp;
        }
      }
    }
    for (int i = 0; i < A.length; i++) {
      if (A[i] != i + 1) {
        return i + 1;
      }
    }
    return A.length + 1;
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
    int[] A = {2, 1};
    int result = new temp().firstMissingPositive(A);
    System.out.println(result);
  }
}

