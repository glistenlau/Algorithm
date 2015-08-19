/**
 * Created by YiLIU on 8/18/15.
 */
public class ExpressionTreeNode {
  public String symbol;
  public ExpressionTreeNode left, right;
  public ExpressionTreeNode(String symbol) {
    this.symbol = symbol;
    this.left = this.right = null;
  }
}
