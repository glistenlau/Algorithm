__author__ = 'yi'


class Solution:

    def isPalindrome(self, s):
        chara = list(s.lower())
        N = len(chara)
        if N == 0:
            return True
        i = 0
        j = N -1
        while i <= j:
            while i < j and not (chara[i].isalpha() or chara[i].isdigit()):
                i += 1
            while i < j and not (chara[j].isalpha() or chara[j].isdigit()):
                j -= 1
            if chara[i] != chara[j]:
                return False
            i += 1
            j -= 1
        return True

if __name__ == '__main__':
    test = 'ab2a'
    s = Solution()
    print s.isPalindrome(test)
