__author__ = 'yi'
class Solution:
    # @param s, a string
    # @return a string
    def reverseWords(self, s):
        reversed = ''
        lists = list(s)
        j = len(s)
        for i in range(len(s))[::-1]:
            if lists[i] == ' ':
                j = i
            elif lists[i - 1] == ' ' or i == 0:
                if len(reversed) != 0:
                    reversed += ' '
                reversed += s[i:j]
        return reversed

if __name__ == '__main__':
    s = raw_input()
    test = Solution()
    print test.reverseWords(s)
