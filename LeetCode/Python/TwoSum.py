class Solution:
    # @return a tuple, (index1, index2)
    def twoSum(self, num, target):
        maps = {}
        for i in range(len(num)):
            if target - num[i] in maps:
                return maps.get(target - num[i]) + 1, i + 1
            maps[num[i]] = i
        return None
