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
  public int evaluateExpression(String[] expression) {
    int[] poriority = new int[expression.length];
    Stack<Integer> operator = new Stack<>();
    Stack<Integer> operand = new Stack<>();
    int base = 0;
    for (int i = 0; i < expression.length; i++) {
      String e = expression[i];
      if (e.equals("(")) {
        base += 10;
        continue;
      }
      if (e.equals(")")) {
        base -= 10;
        continue;
      }
      poriority[i] = getPoriority(e, base);
      if (poriority[i] == 0) {
        operand.push(Integer.parseInt(e));
      } else {
        while (!operator.isEmpty() && poriority[i] <= poriority[operator.peek()]) {
          operand.push(op(operand, expression[operator.pop()]));
        }
        operator.push(i);
      }
    }
    while (!operator.isEmpty()) {
      operand.push(op(operand, expression[operator.pop()]));
    }

    return operand.pop();
  }

  private int getPoriority(String s, int base) {
    if (s.equals("*") || s.equals("/")) {
      return base + 10;
    }
    if (s.equals("+") || s.equals("-")) {
      return base + 1;
    }
    return 0;
  }

  private int op(Stack<Integer> operand, String e) {
    int a = operand.pop();
    int b = operand.pop();
    if (e.equals("+")) {
      return b + a;
    }
    if (e.equals("-")) {
      return b - a;
    }
    if (e.equals("*")) {
      return b * a;
    }
    if (e.equals("/")) {
      return b / a;
    }

    return -1;
  }


  public static void main(String[] args) {
    String[] temp = {"3", "-", "4", "+", "5"};

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"O"};
    char[][] board = new char[strA.length][strA[0].length()];
    int i = 0;
    for (String str: strA) {
      board[i++] = str.toCharArray();
    }

    char[][] sodoku = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    int[] A = {};
    int[][] matrix1 = {{2, 1}};

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.right = new TreeNode(5);
//    root.left.left = new TreeNode(3);
//    root.left.right = new TreeNode(4);
//    root.right.right = new TreeNode(6);
//    TreeLinkNode tln = new TreeLinkNode(1);
//    tln.left = new TreeLinkNode(2);
//    tln.right = new TreeLinkNode(3);
//    tln.left.left = new TreeLinkNode(4);
//    tln.left.right = new TreeLinkNode(5);
//    tln.right.right = new TreeLinkNode(7);


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
    Point[] pts= {new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};

    ListNode head = new ListNode(4);
    head.next = new ListNode(3);
    head.next.next = new ListNode(1);
    head.next.next.next = new ListNode(5);
    head.next.next.next.next = new ListNode(2);
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
    System.out.println(new temp().evaluateExpression(temp));

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

