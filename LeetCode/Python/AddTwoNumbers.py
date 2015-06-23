__author__ = 'yi'


class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1, l2):
        dummyHead = ListNode(0)
        result = dummyHead;
        carry = 0
        while l1 != None or l2 != None:
            o1 = l1 if l1 != None else ListNode(0)
            o2 = l2 if l2 != None else ListNode(0)
            result.next.val = (o1.val + o2.val) % 10 + carry
            carry = (o1.val + o2.val) / 10
            o1 = o1.next
            o2 = o2.next
        if carry != 0:
            result.next = ListNode(carry)
        return dummyHead.next