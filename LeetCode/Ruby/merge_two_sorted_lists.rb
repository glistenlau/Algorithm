require '../LeetCode/list_node'
class MergeTwoSortedLists
  def merge_two_lists(l1, l2)
    dummy = ListNode.new(0)
    merged = ListNode.new(0)
    dummy.next = merged
    while l1 != nil && l2 != nil
      if (l1.val > l2.val)
        merged.next = ListNode.new(l2.val)
        l2 = l2.next
      else
        merged.next = ListNode.new(l1.val)
        l1 = l1.next
      end
      merged = merged.next
    end
    merged.next = l1 != nil ? l1 : merged.next
    merged.next = l2 != nil ? l2 : merged.next
    return dummy.next.next
  end
end

l1 = ListNode.new(1)
l1.next = ListNode.new(2)
l1.next.next = ListNode.new(3)
l2 = ListNode.new(1)
l2.next = ListNode.new(3)
l2.next.next = ListNode.new(5)

test = MergeTwoSortedLists.new().merge_two_lists(l1, nil)
while test != nil
  puts test.val
  test = test.next
end