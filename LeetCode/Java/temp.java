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
  public String multiply(String num1, String num2) {
    if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0 || num1 == "0" || num2 == "0") {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    int n = num1.length() + num2.length() - 2;;
    int carry = 0;
    int sum;
    for (int i = n; i >= 0; i--) {
      sum = carry;
      for(int i1 = 0; i1 < num1.length(); i1++) {
        int i2 = i - i1;
        if (i2 >= 0 && i2 < num2.length()) {
          sum += Character.getNumericValue(num1.charAt(i1)) * Character.getNumericValue(num2.charAt(i2));
        }
      }
      carry = sum / 10;
      sum %= 10;
      sb.insert(0, sum);
    }
    while (carry != 0) {
      sum = carry % 10;
      carry /= 10;
      sb.insert(0, sum);
    }
    return sb.toString();
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
    int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
    int a = Integer.MIN_VALUE;
    int b = -2;
    b = b >>> 1;
    a = a >> 1;
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
    System.out.println(new temp().multiply("9133", "0"));
    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

