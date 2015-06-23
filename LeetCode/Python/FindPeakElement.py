__author__ = 'yi'


class Solution:
    # @param num, a list of integer
    # @return an integer
    def findPeakElement(self, num):
        l = 0
        r = len(num) - 1
        mid = r / 2
        while l < r:
            if num[mid] < num[mid + 1]:
                l = mid + 1
            else:
                r = mid

            mid = (r + l) / 2
        return l
