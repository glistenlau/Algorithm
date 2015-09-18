import java.util.*;

/**
 * Created by YiLIU on 9/17/15.
 */
public class TopView {
  private class Node{
    TreeNode node;
    int index;
    Node(TreeNode node, int index) {
      this.node = node;
      this.index = index;
    }
  }

  public List<Integer> topView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    return levelTraverse(root);
  }

  private List<Integer> levelTraverse(TreeNode root) {
    HashMap<Integer, Integer> map = new HashMap<>();
    Queue<Node> level = new LinkedList<>();

    int first = 0;
    level.add(new Node(root, 0));

    while (!level.isEmpty()) {
      for (int i = level.size(); i >= 0; i--) {
        Node cur = level.poll();
        first = Math.min(first, cur.index);
        if (!map.containsKey(cur.index)) {
          map.put(cur.index, cur.node.val);
        }
        if (cur.node.left != null) {
          level.offer(new Node(cur.node.left, cur.index - 1));
        }
        if (cur.node.right != null) {
          level.offer(new Node(cur.node.right, cur.index + 1));
        }
      }
    }

    List<Integer> ans = new ArrayList<>();

    for (int i = 0; i < map.size(); i++, first++) {
      ans.add(map.get(first));
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
    root.right.left.left = new TreeNode(4);
    root.right.left.left.left = new TreeNode(5);

    System.out.println(new TopView().topView(root));
  }
}
