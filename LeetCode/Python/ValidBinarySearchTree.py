__author__ = 'yi'


class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def validNode(self, root, maxval, minval):
        if root is None:
            return True
        return (maxval is None or root.val < maxval) and (minval is None or root.val > minval)\
            and self.validNode(root.left, root.val, minval) and self.validNode(root.right, maxval, root.val)

    def isValidBST(self, root):
        return self.validNode(root, None, None)
