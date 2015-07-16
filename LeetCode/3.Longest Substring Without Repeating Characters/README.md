Longest Substring Without Repeating Characters
---
[LeetCode OJ Link](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

要找最长的不包含重复字符的子字符串，就要把子字符串中出现过的字符记录下来以查询，这里我们维护一个大小256的数组(ASCII码的范围是0-255)，将出现过的字符的位置记录下来，然后使用两个指针，一个指向当前不包含重复字符的子字符串的开头，另一个用来遍历字符串。