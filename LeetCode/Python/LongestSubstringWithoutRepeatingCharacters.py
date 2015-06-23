__author__ = 'yi'
class Solution:
    def lengthOfLongestSubstring(self, s):
        chardict = {}
        longest = 0
        j = 0
        for i in range(len(s)):
            if chardict.has_key(s[i]) and chardict[s[i]] >= j:
                j = chardict[s[i]] + 1
            chardict[s[i]] = i
            longest = max(longest, i - j + 1)
        return longest

if __name__ == "__main__" :
    s = raw_input('Enter input string: ')
    print Solution().lengthOfLongestSubstring(s)
