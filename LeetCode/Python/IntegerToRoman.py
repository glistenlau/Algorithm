__author__ = 'YiLIU'
class Solution:
    def __init__(self):
        self.units = ["I", "V", "X"]
        self.tens = ["X", "L", "C"]
        self.hundreds = ["C", "D", "M"]
        self.result = ""

    def intToRoman(self, num):
        if num >= 1000:
            digit = num / 1000
            num -= digit * 1000
            self.result = "M" * digit
            self.result += self.intToRoman(num)
        elif num >= 100:
            digit = num / 100
            num -= digit * 100
            self.result = self.intToRomanHelper(digit, self.hundreds)
            self.result += self.intToRoman(num)
        elif num >= 10:
            digit = num /10;
            num -= digit * 10
            self.result = self.intToRomanHelper(digit, self.tens)
            self.result += self.intToRoman(num)
        else:
            self.result = self.intToRomanHelper(num, self.units)
        return self.result

    def intToRomanHelper(self, digit, level):
        if digit >= 9:
            return level[0] * (10 - digit) + level[2]
        elif digit >= 5:
            return level[1] + level[0] * (digit - 5)
        elif digit >= 4:
            return level[0] * (digit - 3) + level[1]
        else:
            return level[0] * digit

print Solution().intToRoman(2 ** 31 - 1)
print Solution().intToRoman(1990)
print Solution().intToRoman(2014)
