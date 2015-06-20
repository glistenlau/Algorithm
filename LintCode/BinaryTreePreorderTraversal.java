import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by YiLIU on 6/20/15.
 */
public class BinaryTreePreorderTraversal {
  public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> save = new Stack<>();
    TreeNode cur = root;
    save.push(cur);
    while (!save.empty() && cur != null) {
      result.add(cur.val);
      if (cur.right != null) {
        save.push(cur.right);
      }
      cur = cur.left != null ? cur.left : save.pop();
    }
    return result;
  }
}
