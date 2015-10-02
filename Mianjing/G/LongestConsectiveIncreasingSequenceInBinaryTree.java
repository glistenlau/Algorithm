import java.util.ArrayList;
import java.util.List;

/**
 * longest consective increasing sequence in binary tree.(start point happen anywhere in the node, not
 * necessary start from root),
 */
public class LongestConsectiveIncreasingSequenceInBinaryTree {
  public List<Integer> longestConsecutiveInABinaryTree(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }

    helper(root, new ArrayList<Integer>(), ans);

    return ans;
  }

  private void helper(TreeNode root, List<Integer> taken, List<Integer> ans)  {
    if (root == null) {
      return;
    }

    taken.add(root.val);


    if (root.left != null && root.left.val == root.val + 1) {
      helper(root.left, taken, ans);
    } else {
      helper(root.left, new ArrayList<>(), ans);
    }
    if (root.right != null && root.right.val == root.val + 1) {
      helper(root.right, taken, ans);
    } else {
      helper(root.right, new ArrayList<>(), ans);
    }

    if (taken.size() > ans.size()) {
      ans.clear();
      ans.addAll(taken);
    }
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(2);
    root.right.right = new TreeNode(4);
    root.right.right.right = new TreeNode(5);

    System.out.println(new LongestConsectiveIncreasingSequenceInBinaryTree()
        .longestConsecutiveInABinaryTree(root));
  }
}
