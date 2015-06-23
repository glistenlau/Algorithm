import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YiLIU on 6/20/15.
 */
public class BinaryTreeLevelOrderTraversalII {
  public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> BFS = new LinkedList<>();
    BFS.offer(root);

    while (!BFS.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<Integer>();
      int size = BFS.size();
      for (int i = 0; i < size; ++i) {
        TreeNode cur = BFS.poll();
        level.add(cur.val);

        if (cur.left != null) {
          BFS.offer(cur.left);
        }
        if (cur.right != null) {
          BFS.offer(cur.right);
        }
      }
      result.add(0, level);
    }
    return result;
  }
}
