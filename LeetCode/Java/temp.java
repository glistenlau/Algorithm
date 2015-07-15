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
  public String binaryRepresentation(String n) {
    if (n == null || n.length() == 0) {
      return "ERROR";
    }

    StringBuilder intStr = new StringBuilder();
    StringBuilder decStr = new StringBuilder();
    double decPart = Double.parseDouble(n.substring(n.indexOf('.')));

    while(decPart > 0.0) {
      if (decStr.length() > 31) {
        return "ERROR";
      }
      decPart *= 2.0;
      if (decPart >= 1.0) {
        decStr.append(1);
        decPart -= 1.0;
      } else {
        decStr.append(0);
      }
    }
   int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
    while (intPart > 0) {
      intStr.insert(0, intPart % 2);
      intPart /= 2;
    }
    if (decStr.length() == 0) {
      return intStr.toString();
    } else {
      return intStr.toString() + "." + decStr.toString();
    }
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
    String result = new temp().binaryRepresentation("11.25");
    System.out.println(result);
  }
}

