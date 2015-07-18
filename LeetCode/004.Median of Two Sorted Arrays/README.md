Median of Two Sorted Arrays
---
[LeetCode OJ Link](https://leetcode.com/problems/median-of-two-sorted-arrays/)

要找两个数组的中位数，我们就是找这两个数组中第(m + n) / 2 + 1大的那个数，如果数组的总长度为偶数，需要找到中间两个数除以2。就把问题转化为如何在两个数组中找到第k大的那个数。

我们比较两个数组中第k / 2大的数，例如分别为a和b， 如果 a < b， 因为数组是排序的， 则a前面的所有数都小于b，所以就确定了a前面的数一定都在我们要找的第k大的数之前，这样就可以把a和它之前的数扔掉，然后继续找第k － k ／ 2大的数， 直到找到k为1，或者其中一个数组全部被扔掉了为止。