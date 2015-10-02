import java.util.Iterator;

/**
 * Created by YiLIU on 9/29/15.
 */
public class BSTIterator implements Iterator<Integer> {
  private TreeNode pre;
  private TreeNode cur;

  BSTIterator(TreeNode root) {
    this.pre = null;
    this.cur = root;
    while (cur != null && cur != null) {
      pre = cur;
      cur = cur.left;
    }
    cur = pre;
    pre = null;
  }


  @Override
  public Integer next() {
    int ans = cur.val;
    pre = cur;
    if (cur.right != null) {
      cur = cur.right;
      while (cur != null) {
        pre = cur;
        cur = cur.left;
      }
      cur = pre;
      pre = null;
    } else {
      cur = cur.parent;
      while (cur != null && cur.right == pre) {
        pre = cur;
        cur = cur.parent;
      }
    }
    return ans;
  }

  @Override
  public boolean hasNext() {
    return cur != null;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.left.parent = root;
    root.left.right = new TreeNode(2);
    root.left.right.parent = root.left;
    root.right = new TreeNode(4);
    root.right.parent = root;
    BSTIterator iter = new BSTIterator(root);
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }

}

