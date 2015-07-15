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
  public int updateBits(int n, int m, int i, int j) {
    int copy = n;
    copy = copy >>> i;
    copy = copy << i;
    copy = n - copy;
    m = m << i;
    m = m + copy;
    n = n >>> j;
    n = n << j;
    n = n + m;
    return n;
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
    int[] A = {1, 2, -3, 1};
    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    int result = new temp().updateBits(1,-1,0,31);
    System.out.println(result);
  }
}

