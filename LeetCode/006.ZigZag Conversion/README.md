ZigZag Conversion
---
[LeetCode OJ Link](https://leetcode.com/problems/zigzag-conversion/)

这道题是把字符串转换为之字形顺序，这个转换是有一定规律的，拿题目中的例子“PAYPALISHIRING"来说， 转换成之字形是这样的：

> P- - - - -A- - - -H- - - -N  
> A- -P- - L- -S- -I- -I- - G  
> Y- - - - - I - - - -R

可以看到其中有这是一个每4个字母的一个V字型循环：  

> P  
> A- -P  
> Y

所以如果要转化为k行的之字型顺序，就是每2k - 2个字母构成一个V字型循环，所以我们可以用初始化为0和2k - 2的指针，来逐行遍历每个小V循环以完成之字形转化的操作，其中要注意一头一尾是只有一个字母的特殊情况。