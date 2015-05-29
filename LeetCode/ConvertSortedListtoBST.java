/**
 * Created by yi on 5/5/15.
 */
public class ConvertSortedListtoBST {
    private ListNode list;

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        list = head;
        while (list != null) {
            list = list.next;
            n++;
        }
        list = head;
        return sortedListToBST(0, n - 1);
    }

    private TreeNode sortedListToBST(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        TreeNode right = sortedListToBST(mid + 1, end);
        parent.left = left;
        parent.right = right;
        list = list.next;
        return parent;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
