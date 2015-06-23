import javax.swing.text.ComponentView;
import java.util.Scanner;

/**
 * Created by yi on 5/4/15.
 */
public class ConvertSortedArraytoBST {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = new int[in.nextInt()];
        for (int i = 0; i < nums.length; ++i) {
            nums[i] = in.nextInt();
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return findMidNode(nums, nums.length - 1, 0);
    }


    private TreeNode findMidNode(int[] nums, int max, int min) {
        if (max < min) return null;
        int mid = (max + min) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = findMidNode(nums, mid - 1, min);
        root.right = findMidNode(nums, max, mid + 1);
        return root;
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
