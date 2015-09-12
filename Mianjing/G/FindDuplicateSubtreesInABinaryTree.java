import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Find a Duplicate subtrees in a Binary Tree and print out.
 *
 * 暴力解的思路是以每一个子树作为目标，遍历整个数找和这个数相同的子树，时间复杂度应该是O(n^3)。
 * 第二种方法是一个preorder的顺序遍历和inorder的顺序遍历可以决定一棵独特子树，所以只要找两个相等的到两棵子树的preorder遍历结果和inorder的遍历结果，
 * 他们就是一对重复子树。
 */
public class FindDuplicateSubtreesInABinaryTree {
  public TreeNode findDuplicateSubtreesInABinaryTree(TreeNode root) {
    if (root == null) {
      return null;
    }

    TreeNode rst = findSubTree(root, root);
    return rst;
  }

  private TreeNode findSubTree(TreeNode root, TreeNode subTree) {
    if (subTree == null) {
      return null;
    }

    boolean l = find(root, subTree.left);
      if (l) {
        return subTree.left;
      }

    boolean r = find(root, root.right);
      if (r) {
        return subTree.right;
      }

    TreeNode left = findSubTree(root, subTree.left);
    if (left != null) {
      return left;
    }
    TreeNode right = findSubTree(root, subTree.right);
    if (right != null) {
      return right;
    }

    return null;
  }

  private boolean find(TreeNode root, TreeNode subTree) {
    if (root == null && subTree == null) {
      return true;
    } else if (root == null) {
      return false;
    } else if (subTree == null) {
      return false;
    }

    if (root.val == subTree.val && root != subTree) {
      if (find(root.left, subTree.left) && find(root.right, subTree.right)) {
        return true;
      }
    }

    return find(root.left, subTree) || find(root.right, subTree);
  }

  public TreeNode findDuplicate(TreeNode root) {
    HashMap<TreeNode, String> preOrder = new HashMap<>();
    preOrder(root, preOrder);
    HashMap<String, ArrayList<TreeNode>> inOrder = new HashMap<>();
    TreeNode[] dup = new TreeNode[1];
    inOrderSearch(root, inOrder, preOrder, dup);
    return dup[0];
  }

  private String preOrder(TreeNode root, HashMap<TreeNode, String> preOrder) {
    if (root == null) {
      return "$,";
    }


    String ans = "" + root.val + "," + preOrder(root.left, preOrder) + preOrder(root.right,
        preOrder);

    preOrder.put(root, ans);

    return ans;
  }

  private String inOrderSearch(TreeNode root, HashMap<String, ArrayList<TreeNode>> inOrder,
                                 HashMap<TreeNode, String> preOrder, TreeNode[] dup) {
    if (root == null) {
      return "$,";
    }

    String left = inOrderSearch(root.left, inOrder, preOrder, dup);
    String right = inOrderSearch(root.right, inOrder, preOrder, dup);

    String ans = left + root.val + "," + right;
    if (inOrder.containsKey(ans)) {
      for (TreeNode node: inOrder.get(ans)) {
        if (preOrder.get(root).equals(preOrder.get(node))) {
          dup[0] = node;
        }
      }

      inOrder.get(ans).add(root);
    } else {
      inOrder.put(ans, new ArrayList<>(Arrays.asList(root)));
    }

    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode (4);
    root.left.right = new TreeNode (5);
    root.right.right = new TreeNode(2);
    root.right.right.left = new TreeNode(4);
    root.right.right.right = new TreeNode(5);

    TreeNode test = new FindDuplicateSubtreesInABinaryTree().findDuplicate(root);
    return;
  }
}
