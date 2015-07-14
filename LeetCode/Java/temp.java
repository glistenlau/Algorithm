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
  public int fastPower(int a, int b, int n) {
    if (n == 0) {
      return 1 % b;
    }
    long product = fastPower(a, b, n / 2);
    product = (product * product) % b;
      if (n % 2 == 1) {
        product = (product * a) % b;
      }
    return (int)product;
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
    int result = new temp().fastPower(2, 2147483647, 2147483647);
    System.out.println(result);
  }
}

