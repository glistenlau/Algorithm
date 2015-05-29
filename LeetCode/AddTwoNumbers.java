import java.util.Scanner;

/**
 * Created by yi on 4/22/15.
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        AddTwoNumbers test = new AddTwoNumbers();
        System.out.println(test.addTwoNumbers(l1, l2).val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = dummyHead;
        int carry = 0;
        while (l1 != null & l2 != null) {
            p.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            p = p.next;
        }
        if (l1 != null) {
            while (carry == 0) {
                p.next.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
                p = p.next;
            }
            p = l1;
        }
        if (l2 != null) {
            while (carry == 0) {
                p.next.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
                p = p.next;
            }
            p = l2;
        }
        return dummyHead.next;
    }
}
