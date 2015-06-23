__author__ = 'YiLIU'
class Solution:
    MAX = (2 ** 31 - 1) / 10
    def myAtoi(self, str):
        neg, detected, digit = False, False, False
        result = 0
        for c in str:
            if not detected:
                if c == " ":
                    continue
                elif c == "-":
                    neg, detected = True, True
                    continue
                elif c == "+":
                    neg, detected = False, True
                    continue
                elif c.isdigit():
                    neg, detected, digit = False, True, True
                    result *= 10 if result != 0 else 1
                    result += int(c)
                else:
                    return 0
            else:
                if c.isdigit():
                    digit = True
                    if result > self.MAX or (result == self.MAX and int(c) > 7):
                        return 2147483647 if not neg else -2147483648
                    result *= 10 if result != 0 else 1
                    result += int(c)
                elif digit:
                    return result if not neg else -result
                else:
                    return 0
        return result if not neg else -result

print Solution().myAtoi(" -0012a42")
