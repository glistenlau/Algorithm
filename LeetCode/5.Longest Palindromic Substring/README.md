Longest Palindromic Substring
---
[LeetCode OJ Linke](https://leetcode.com/problems/longest-palindromic-substring/)

这道题是要寻找最长的回文，简单的思路就是把所有回文遍历出来，然后取其中最长的那个。具体实现就是遍历字符串中的每个字符，然后以它为中心向两边展开，从而找到最长的回文。需要注意的是，中间两个相同的字符向外展开也可以构成回文。