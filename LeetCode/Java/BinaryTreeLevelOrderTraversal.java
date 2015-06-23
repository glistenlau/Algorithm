import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YiLIU on 6/20/15.
 */
public class BinaryTreeLevelOrderTraversal {
  public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    Queue<TreeNode> BFS = new LinkedList<>();

    if (root == null) {
      return result;
    }
    BFS.add(root);

    while (!BFS.isEmpty()) {
      ArrayList<Integer> level = new ArrayList<>();
      int size = BFS.size();
      for (int i = 0; i < size; ++i) {
        TreeNode cur = BFS.poll();
        level.add(cur.val);
        if (cur.left != null) {
          BFS.add(cur.left);
        }
        if (cur.right != null) {
          BFS.add(cur.right);
        }
      }
      result.add(level);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode test = new TreeNode(1);
    test.left = new TreeNode(2);
    test.right = new TreeNode(3);
    System.out.println(new BinaryTreeLevelOrderTraversal().levelOrder(test));
  }
}
