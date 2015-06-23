require '../LeetCode/list_node'
class SwapNodesInPairs
  def swap_pairs(head)
    dummy = ListNode.new(0)
    tail = dummy
    if (head.nil? || head.next.nil?)
      return head
    end
    while head != nil && head.next != nil
      tail.next = head.next
      head.next = tail.next.next
      tail.next.next = head
      head = tail.next.next.next
      tail = tail.next.next
    end
    return dummy.next
  end
end

l2 = ListNode.new(1)
l2.next = ListNode.new(3)
l2.next.next = ListNode.new(5)
l2.next.next.next = ListNode.new(7)
test = SwapNodesInPairs.new().swap_pairs(l2)
while test != nil
  puts test.val
  test = test.next
end