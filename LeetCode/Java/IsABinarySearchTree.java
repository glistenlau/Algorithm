/**
 * Created by YiLIU on 6/20/15.
 */
public class IsABinarySearchTree {
  private class result{
    int maxV, minV;
    boolean BST;
    result (int maxV, int minV, boolean BST) {
      this.maxV = maxV;
      this.minV = minV;
      this.BST = BST;
    }
  }
  public boolean isBST(TreeNode root) {
    return DFS(root).BST;
  }

  private result DFS(TreeNode root) {
    if (root == null) {
      return new result(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
    }

    result left = DFS(root.left);
    result right = DFS(root.right);

    if (left.maxV > root.val || right.minV < root.val) {
      return new result(0, 0, false);
    }

    int maxV = Math.max(right.maxV, root.val);
    int minV = Math.min(left.minV, root.val);

    return new result(maxV, minV, left.BST && right.BST);
  }

  public static void main(String[] args) {
    TreeNode test = new TreeNode(10);
    test.left = new TreeNode(8);
    test.right = new TreeNode(12);
    test.left.left = new TreeNode(7);
    test.left.right = new TreeNode(9);
    test.right.left = new TreeNode(1);
    test.right.right = new TreeNode(256);
    System.out.println(new IsABinarySearchTree().isBST(test));
  }
}
