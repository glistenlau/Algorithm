__author__ = 'yi'


class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return an integer
    def strStr(self, haystack, needle):
        for i in range(len(haystack) + 1):
            for s in range(len(needle) + 1):
                if s == len(needle):
                    return i
                if i + s >= len(haystack):
                    return -1
                if haystack[i + s] != needle[s]:
                    break


if __name__ == '__main__':
    s = ''
    n = ''
    re = Solution().strStr(s, n)
    print(re)
