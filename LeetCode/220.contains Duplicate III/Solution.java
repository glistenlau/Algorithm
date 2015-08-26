public class Solution {

  private class TreeNode {
    int val, index;
    TreeNode left, right;

    TreeNode (int val, int index) {
      this.val = val;
      this.index = index;
      this.left = this.right = null;
    }
  }

  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (nums == null || nums.length < 2 || k == 0) {
      return false;
    }
    TreeNode root = null;

    for (int i = 0; i < nums.length; i++) {
      if (searchBST(root, nums, i, k, t)) {
        return true;
      }
      root = insertBST(root, nums, i);
    }

    return false;
  }

  private TreeNode insertBST(TreeNode root, int[] nums, int i) {
    if (root == null) {
      return new TreeNode(nums[i], i);
    }

    if (nums[i] > root.val) {
      root.right = insertBST(root.right, nums, i);
    } else {
      root.left = insertBST(root.left, nums, i);
    }
    return root;
  }

  private boolean searchBST(TreeNode root, int[] nums, int i, int k, int t) {
    if (root == null) {
      return false;
    }
    if (Math.abs((long)nums[i] - root.val) > t) {
      if (nums[i] > root.val) {
        return searchBST(root.right, nums, i, k, t);
      } else {
        return searchBST(root.left, nums, i, k, t);
      }
    } else {
      if (Math.abs(i - root.index) <= k) {
        return true;
      }
      if (searchBST(root.left, nums, i, k, t) || searchBST(root.right, nums, i, k, t)) {
        return true;
      }
      return false;
    }
  }
}