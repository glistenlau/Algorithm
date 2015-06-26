/**
 * Binary Tree Serialization
 * http://www.lintcode.com/en/problem/binary-tree-serialization/
 *
 * Design an algorithm and write code to serialize and deserialize a binary
 * tree. Writing the tree to a file is called 'serialization' and reading
 * back from the file to reconstruct the exact same binary tree is
 * 'deserialization'.
 *
 * There is no limit of how you deserialize or serialize a binary tree, you
 * only need to make sure you can serialize a binary tree to a string and
 * deserialize this string to the original structure.
 *
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 *   3
 *  / \
 * 9  20
 *   /  \
 * 15   7
 * Our data serialization use bfs traversal. This is just for when you got
 * wrong answer and want to debug the input.
 *
 * You can use other method to do serializaiton and deserialization.
 */
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
class Solution {
  /**
   * This method will be invoked first, you should design your own algorithm
   * to serialize a binary tree which denote by a root node to a string which
   * can be easily deserialized by your own "deserialize" method later.
   */
  public String serialize(TreeNode root) {
    // write your code here
    String result = new String();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
    curLevel.offer(root);
    result += Integer.toString(root.val);
    while (!curLevel.isEmpty()) {
      TreeNode cur = curLevel.poll();
      if (cur == null) {
        result += ",#,#";
        continue;
      }
      if (cur.left != null) {
        result += "," + Integer.toString(cur.left.val);
        curLevel.offer(cur.left);
      } else {
        result += ",#";
        curLevel.offer(null);
      }
      if (cur.right != null) {
        result += "," + Integer.toString(cur.right.val);
        curLevel.offer(cur.right);
      } else {
        result += ",#";
        curLevel.offer(null);
      }

    }
    return result;
  }

  /**
   * This method will be invoked second, the argument data is what exactly
   * you serialized at method "serialize", that means the data is not given by
   * system, it's given by your own serialize method. So the format of data is
   * designed by yourself, and deserialize it here as you serialize it in
   * "serialize" method.
   */
  public TreeNode deserialize(String data) {
    // write your code here
    TreeNode dummy = new TreeNode(0);
    if (data == null || data.length() == 0) {
      return null;
    }
    String[] nums = data.split(",");
    TreeNode root = new TreeNode(Integer.parseInt(nums[0]));

    dummy.left = root;
    Queue<TreeNode> myQueue = new LinkedList<TreeNode>();
    myQueue.offer(root);
    int i = 1;
    while(i < nums.length) {
      TreeNode cur = myQueue.poll();
      if (cur == null) {
        i += 2;
        continue;
      }
      if (nums[i].equals("#")) {
        myQueue.offer(null);
      } else {
        cur.left = new TreeNode(Integer.parseInt(nums[i]));
        myQueue.offer(cur.left);
      }
      i += 1;
      if (i >= nums.length) {
        break;
      }
      if (nums[i].equals("#")) {
        myQueue.offer(null);
      } else {
        cur.right = new TreeNode(Integer.parseInt(nums[i]));
        myQueue.offer(cur.right);
      }
      i += 1;
    }
    return dummy.left;
  }
}