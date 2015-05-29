import java.util.HashMap;
import java.util.Map;

/**
 * Created by yi on 4/23/15.
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode dummyHead = new RandomListNode(0);
        RandomListNode copy = head;
        RandomListNode temp = dummyHead;
        Map<RandomListNode, RandomListNode> ref = new HashMap<RandomListNode, RandomListNode>();
        while (copy != null) {
            temp.next = new RandomListNode(copy.label);
            ref.put(copy, temp.next);
            temp = temp.next;
            copy = copy.next;
        }
        copy = head;
        temp = dummyHead;
        while (copy != null) {
            temp.next.random = ref.get(copy.random);
            temp = temp.next;
            copy = copy.next;
        }
        return dummyHead.next;
    }

    public RandomListNode copyRandomList1(RandomListNode head) {
        RandomListNode ori = head;
        while (ori != null) {
            RandomListNode next = head.next;
            ori.next = new RandomListNode(ori.label);
            ori.next.next = next;
            ori = next;
        }
        ori = head;
        while (ori != null) {
            ori.next.random = ori.random != null ? ori.random.next : null;
            ori = ori.next.next;
        }
        ori = head;
        RandomListNode copyHead = ori.next != null ? ori.next : null;
        while (ori != null) {
            RandomListNode copy = ori.next;
            ori.next = copy.next;
            ori = ori.next;
            copy.next = ori != null ? ori.next : null;
        }
        return copyHead;

    }
}
