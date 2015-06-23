import java.util.Comparator;

/**
 * Created by yi on 4/22/15.
 */
public class MergeKSortedLists {
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode result = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null) result.next = l1;
        if (l2 != null) result.next = l2;
        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0)
            return null;
        for (int i = 2; i < k; i *= 2) {
            for (int j = 0; j < (k + 1) / 2; j += 2) {
                ListNode[] copy = lists;
                ListNode y = copy[j + 1] == null ? null : copy[j + 1];
                lists = new ListNode[(k + 1) / i];
                lists[j] = mergeTwoLists(copy[j], y);
            }
        }
        return lists[0];
    }
}
