import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
public class temp {

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

  public static void main(String[] args) {
    TreeNode test = new TreeNode(1);
    test.right = new TreeNode(2);
    TreeNode root = new temp().deserialize("1,2,3,#,#,4,5");
    String data = new temp().serialize(root);
      System.out.println(data);
  }
}