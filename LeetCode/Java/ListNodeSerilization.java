/**
 * Created by YiLIU on 7/5/15.
 */
public class ListNodeSerilization {
  public ListNode serilization (String input) {
    String[] split = input.split("->");
    ListNode dummy = new ListNode(0);
    ListNode curt = dummy;
    for (int i = 0; i < split.length; i++) {
      curt.next = new ListNode(Integer.parseInt(split[i]));
      curt = curt.next;
    }
    return dummy.next;
  }

  public static void main(String args) {
    String input = "1->2->3->4->5";
    ListNode test = new ListNode(0).serilization(input);
    return;
  }
}
