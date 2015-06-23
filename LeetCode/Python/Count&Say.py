__author__ = 'yi'


class Solution:
    def countAndSay(self, n):
        if n == 1:
            return '1'
        first = '1'
        for i in range(n - 1):
            first = self.count(first)
        return first


    def count(self, n):
        maps = {}
        charn = list(n)
        result = ''
        for i in range(len(n)):
            if not maps.has_key(charn[i]):
                maps[charn[i]] = 1
                if i != 0:
                    result += str(maps.pop(charn[i - 1])) + charn[i - 1]
            else:
                maps[charn[i]] += 1
        for v in maps:
            result += str(maps[v]) + v
        return result


if __name__ == '__main__':
    test = Solution()
    print test.countAndSay(30)


