__author__ = 'YiLIU'


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        if len(s) == 0:
            return 0
        maps = set()
        ans = 1
        left = 0
        for right in range(len(s)):
            if s[right] in maps:
                while left < right and s[left] is not s[right]:
                    maps.remove(s[left])
                    left += 1
                left += 1
            else:
                maps.add(s[right])
                ans = max(ans, right - left + 1)

        return ans


print(Solution().lengthOfLongestSubstring("abcabbb"))
