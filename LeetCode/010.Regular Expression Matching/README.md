Regular Expression Matching
---
[LeetCode OJ Link](https://leetcode.com/problems/regular-expression-matching/)

这道题有两种解法，一种是一个个递归下去，一种是用动态规划，他们的基本思路都是一样的。

我们用f[i][j]来表示s的前i个字符和p的前j个字符是否匹配，所以当遇到的是非＊号时，检查s字符和当前字符是否匹配，同时检查前面的字符是否匹配。方程为：  
f[i][j] = s.charAt(i - 1) == p.charAt(j - 1) && f[i - 1][j - 1]  
当遇到星号时我们有两种选择：1.当前字母匹配这个星号，这时候方程取决于前面的字母和星号的匹配关系此时方程为：  
f[i][j] = s.charAt(i - 1) == p.charAt(j - 2) && f[i - 1][j]  
2.当前字母忽略这个星号，这时候方程就由这个星号之前的状态决定，方程为：  
f[i][j] = f[i][j - 2]。  
最后f[s.length()][p.length()]就是结果。