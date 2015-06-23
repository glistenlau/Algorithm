import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by yi on 5/4/15.
 */

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }


    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        if (left == -1) return -1;

        int right = maxDepth(root.right);
        if (right == -1) return -1;

        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}



