/**
 * Majority Number II
 * www.lintcode.com/en/problem/majority-number-ii/
 *
 * Given an array of integers, the majority number is the number that occurs
 * more than 1 / 3 of the size of the array. Find it.
 *
 * Example
 * Given [1,2, 1, 2, 1, 3, 3], return 1.
 */

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return -1;
        }

        int candidate1 = 0;
        int candidate2 = 0;
        int count1 = 0;
        int count2 = 0;

        for (int n: nums) {
            if (n == candidate1) {
                count1++;
            } else if (n == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = n;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int n: nums) {
            if (n == candidate1) {
                count1++;
            }
            if (n == candidate2) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }
}


