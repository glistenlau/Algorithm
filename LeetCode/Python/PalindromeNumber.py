__author__ = 'yi'
class Solution:
    def isPalindrome(self, x):
        copy = x
        maxdiv = 1
        if x < 0:
            return False
        while copy >= 10:
            copy /= 10
            maxdiv *= 10
        copy = x
        while maxdiv != 0:
            left = copy / maxdiv
            right = copy % 10
            if left != right:
                return False
            copy = copy % maxdiv / 10
            maxdiv /= 100
        return True

if __name__ == '__main__':
    x = input('Enter number: ')
    print Solution().isPalindrome(x)