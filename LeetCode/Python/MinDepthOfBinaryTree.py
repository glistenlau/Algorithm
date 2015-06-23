from collections import deque

__author__ = 'yi'


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def minDepth(self, root):
        store = deque([root])
        right_most = root
        level = 1
        while store is not None:
            copy = store.popleft()
            if copy.right is None and copy.left is None:
                break
            if copy.left is not None:
                store.append(copy.left)
            if copy.right is not None:
                store.append(copy.right)
            if copy == right_most:
                level += 1
                right_most = copy.right
        return level


if __name__ == '__main__':
    root = TreeNode(input())
    print(Solution().minDepth(root))