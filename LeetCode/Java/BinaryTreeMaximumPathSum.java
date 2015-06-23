/**
 * Created by yi on 5/5/15.
 */
public class BinaryTreeMaximumPathSum {
    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }

    private int pathSum(TreeNode root) {
        if (root == null) return 0;
        int leftBranch = pathSum(root.left);
        int rightBranch = pathSum(root.right);
        int sumNode = 0;
        sumNode = leftBranch + root.val > root.val ? leftBranch + root.val : root.val;
        sumNode = rightBranch + root.val > root.val ? rightBranch + sumNode : sumNode;
        max = sumNode > max ? sumNode : max;
        int maxBranch = Math.max(leftBranch, rightBranch);
        return root.val + maxBranch > root.val ? root.val + maxBranch : root.val;
    }

    private class ResultType {
        int singlePath, maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(root));
    }

}
