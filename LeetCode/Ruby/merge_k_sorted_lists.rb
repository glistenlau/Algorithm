require '../LeetCode/list_node'
class MergeKSortedLists
  def merge_k_lists(lists)
    return nil if lists.size == 0
    sorted = Queue.new
    lists.each do |list|
      sorted.enq(list)
    end
    while sorted.size > 1
      l1 = sorted.deq()
      l2 = sorted.deq()
      dummy = ListNode.new(0)
      cur = dummy
      while !l1.nil? && !l2.nil?
        if l1.val > l2.val
          cur.next = ListNode.new(l2.val)
          l2 = l2.next
        else
          cur.next = ListNode.new(l1.val)
          l1 = l1.next
        end
        cur = cur.next
      end
      cur.next = l1 if !l1.nil?
      cur.next = l2 if !l2.nil?
      sorted.enq(dummy.next)
    end
    return sorted.deq()
  end
end

l1 = ListNode.new(1)
l1.next = ListNode.new(2)
l1.next.next = ListNode.new(3)
l2 = ListNode.new(1)
l2.next = ListNode.new(3)
l2.next.next = ListNode.new(5)

test = [l1, l2]
result = MergeKSortedLists.new().merge_k_lists(test)
while !result.nil?
  puts result.val
  result = result.next
end
