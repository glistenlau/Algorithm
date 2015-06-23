__author__ = 'yi'
class Solution:
    def climbStairs(self, n):
        p = [1, 2, 3]
        q = 1
        for n in range(2, n + 1):
            temp = q
            q += p
            p = temp
        return q

if __name__ == '__main__':
    print Solution().climbStairs(10);