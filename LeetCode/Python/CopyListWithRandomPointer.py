__author__ = 'yi'


class RandomListNode:
    def __init__(self, x):
        self.label = x
        self.next = None
        self.random = None


class Solution:
    def copyRandomList(self, head):
        copy = head
        while copy is not None:
            nextnode = copy.next
            copy.next = RandomListNode(copy.label)
            copy.next.next = nextnode
            copy = nextnode

        copy = head
        while copy is not None:
            copy.next.random = copy.random.next
            copy = copy.next.next

        copy = head
        head_copy = copy.next if copy is not None else None

        while copy is not None:
            next_node = copy.next.next
            copy.next.next = next_node.next
            copy.next = next_node
            copy = next_node
        return head_copy

