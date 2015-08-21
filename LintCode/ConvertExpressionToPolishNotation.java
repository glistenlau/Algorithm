/**
 * Convert Expression to Polish Notation
 * www.lintcode.com/en/problem/convert-expression-to-polish-notation/
 *
 * Given an expression string array, return the Polish notation of this expression. (remove the parentheses).
 *
 * Example
 * For the expression [(5 - 6) * 7], the corresponding polish notation is [* - 5 6 7].
*/
public class Solution {
  /**
   * @param expression: A string array
   * @return: The Polish notation of this expression
   */
  private class ExpressionTreeNode {
    int val;
    String str;
    ExpressionTreeNode left, right;

    ExpressionTreeNode(int val, String str) {
      this.val = val;
      this.str = str;
      left = right = null;
    }
  }

  public ArrayList<String> convertToPN(String[] expression) {
    // write your code here
    ArrayList<String> ans = new ArrayList<>();
    if (expression == null || expression.length == 0) {
      return ans;
    }
    Stack<ExpressionTreeNode> stack = new Stack<>();
    int base = 0;
    for (String str: expression) {
      int priority = Integer.MAX_VALUE;
      if (str.equals("+") || str.equals("-")) {
        priority = base + 1;
      } else if (str.equals("*") || str.equals("/")) {
        priority = base + 10;
      } else if (str.equals("(")) {
        base += 10;
        continue;
      } else if (str.equals(")")) {
        base -= 10;
        continue;
      }
      ExpressionTreeNode cur = new ExpressionTreeNode(priority, str);
      while (!stack.isEmpty() && cur.val <= stack.peek().val) {
        ExpressionTreeNode mid = stack.pop();
        if (stack.isEmpty()) {
          cur.left = mid;
        } else {
          ExpressionTreeNode left = stack.peek();
          if (left.val >= cur.val) {
            left.right = mid;
          } else {
            cur.left = mid;
          }
        }
      }
      stack.push(cur);

    }

    while (stack.size() > 1) {
      ExpressionTreeNode right = stack.pop();
      stack.peek().right = right;
    }

    ExpressionTreeNode root = stack.isEmpty()? null: stack.pop();
    preOrder(root, ans);
    return ans;
  }

  private void preOrder(ExpressionTreeNode root, ArrayList<String> ans) {
    if (root == null) {
      return;
    }

    ans.add(root.str);
    preOrder(root.left, ans);
    preOrder(root.right, ans);
  }
}
