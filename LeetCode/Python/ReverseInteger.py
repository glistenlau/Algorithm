__author__ = 'YiLIU'
class Solution:
    MAX = (2 ** 31 - 1) / 10

    def reverse(self, x):
        neg = True if x < 0 else False
        x = -x if x < 0 else x
        copy, result = x, 0
        while copy >= 10:
            digit = copy % 10
            result += digit
            if result > self.MAX or (result == self.MAX and digit > 7):
                return 0
            result *= 10
            copy /= 10
        result += copy
        if neg:
            result = -result
        return result

print Solution().reverse(-2147483412)