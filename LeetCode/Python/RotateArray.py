__author__ = 'root'
class Solution:
    # @param nums, a list of integer
    # @param k, num of steps
    # @return nothing, please modify the nums list in-place.
    def rotate(self, nums, k):
        n = len(nums)
        k %= n
        temp = []
        for i in range(k)[::-1]:
            temp.append(nums[-i-1])
        for i in range(n - k):
            temp.append(nums[i])
        for i in range(n):
            nums[i] = temp[i]

a = [1,2]
ak = Solution
print(ak.rotate(ak, a, 1))