import java.util.ArrayList;
import java.util.List;

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
  public ArrayList<ArrayList<Integer>> kSumII(int A[], int k, int target) {
    // write your code here
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (A == null || A.length == 0) {
      return result;
    }
    kSumHelper(A, k, target, 0, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void kSumHelper(int[] A, int k, int target, int pos, int sum, ArrayList<Integer> taken, ArrayList<ArrayList<Integer>> result) {
    if (taken.size() == k) {
      if (sum == target) {
        result.add(new ArrayList<Integer>(taken));
      }
      return;
    }

    for (int i = pos; i < A.length; i++) {
      sum += A[i];
      taken.add(A[i]);
      kSumHelper(A, k, target, i + 1, sum, taken, result);
      taken.remove(taken.size() - 1);
      sum -= A[i];
    }
  }


  public static void main(String[] args) {
    int[] A = {1, 2, 3, 4};
    ArrayList<ArrayList<Integer>> ressult = new temp().kSumII(A, 2, 5);
    return;
  }
}

