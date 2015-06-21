/**
 * Created by YiLIU on 6/20/15.
 */
public class LowestCommonAncestor {
  boolean findA = false;
  boolean findB = false;
  public TreeNode lowesetCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    if (root == null || root.val == A.val || root.val == B.val) {
      return root;
    }

    TreeNode left = lowesetCommonAncestor(root.left, A, B);
    TreeNode right = lowesetCommonAncestor(root.right, A, B);

      if (left != null && right != null) {
        return root;
      }
      if (left != null) {
        return left;
      }
      if (right != null) {
        return right;
      }
    return null;
  }

  public static void main(String[] args) {
    TreeNode test = new TreeNode(4);
    test.left = new TreeNode(3);
    test.right = new TreeNode(7);
    test.right.left = new TreeNode(5);
    test.right.right = new TreeNode(6);
    System.out.println(new LowestCommonAncestor().lowesetCommonAncestor(test,
        new TreeNode(5), new TreeNode(8)).val);
  }
}
