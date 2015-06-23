__author__ = 'yi'
class Solution:
    def isValid(self, s):
        dic = {')': '(', '}': '{', ']': '['}
        saved = []
        for p in s:
            if(dic.has_key(p)):
                if(len(saved) == 0 or saved.pop() != dic[p]):
                    return False
            else:
                saved.append(p)
        return len(saved) == 0
if __name__ == '__main__':
    s = '()'
    print Solution().isValid(s)