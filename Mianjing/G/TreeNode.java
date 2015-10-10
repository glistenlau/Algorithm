/**
 * Created by YiLIU on 10/8/15.
 */
public class TreeNode {
  TreeNode left, right, parent;
  int val;
  TreeNode(int val) {
    this.val = val;
    this.left = this.right = this.parent = null;
  }
}
