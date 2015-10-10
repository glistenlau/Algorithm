class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int
        :rtype: List[str]
        """
        if n == 0:
            return list()
        ans = list()
        self.helper(n, n, "", ans)
        return ans

    def helper(self, left, right, taken, ans):
        if (left > right or left < 0 or right < 0):
            return
        if left == 0 and right == 0:
            ans.append(taken)

        self.helper(left - 1, right, taken + '(', ans)
        self.helper(left, right - 1, taken + ')', ans)
