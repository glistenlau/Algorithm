__author__ = 'YiLIU'


class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


def _get_mid_node(head):
    slow = head
    fast = head.next

    while fast is not None and fast.next is not None:
        slow = slow.next
        fast = fast.next.next

    return slow


def _combine(left, right):
    dummy = ListNode(0)
    tail = dummy
    while left is not None and right is not None:
        if left.val <= right.val:
            tail.next = left
            left = left.next
        else:
            tail.next = right
            right = right.next
        tail = tail.next
    if left is not None:
        tail.next = left
    if right is not None:
        tail.next = right

    return dummy.next


class Solution(object):
    def sortList(self, head):
        if head is None or head.next is None:
            return head;

        mid = _get_mid_node(head)
        left = head
        right = mid.next
        mid.next = None

        left = self.sortList(left)
        right = self.sortList(right)

        return _combine(left, right)


if __name__ == '__main__':
    head = ListNode(3)
    head.next = ListNode(2)
    head.next.next = ListNode(1)
    Solution().sortList(head)