require '../LeetCode/list_node'
class AddTwoNumbers
  def add_two_numbers(l1, l2)
    c = 0
    dummyhead = ListNode.new(nil)
    cur = dummyhead
    while(l1 && l2)
      cur.next = ListNode.new (l1.val + l2.val + c) % 10
      c = (l1.val + l2.val + c) / 10
      l1, l2, cur = l1.next, l2.next, cur.next
    end
    while(l1 || l2)
      cur.next = ListNode.new ((l1 ? l1.val : l2.val) + c) % 10
      c = ((l1 ? l1.val : 0) + (l2 ? l2.val : 0) + c) /10
      l1, l2, cur = l1 ? l1.next : l1, l2 ? l2.next : l2, cur.next
    end
    if(c != 0)
      cur.next = ListNode.new(c)
    end
    dummyhead.next
  end
end

l1 = ListNode.new(2)
l1.next = ListNode.new(4)
l1.next.next = ListNode.new(3)
l2 = ListNode.new(5)
l2.next = ListNode.new(6)
l2.next.next = ListNode.new(4)

test = AddTwoNumbers.new.add_two_numbers(l1, l2)
while test
  puts test.val
  test = test.next
end
