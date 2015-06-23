/**
 * Created by yi on 5/5/15.
 */
public class BinaryTreeUpsideDown {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode cur = root;
        TreeNode parent = null;
        TreeNode parentRight = null;
        while (cur != null) {
            TreeNode left = cur.left;
            cur.left = parentRight;
            parentRight = cur.right;
            cur.right = parent;
            parent = cur;
            cur = left;
        }
        return parent;
    }
}
