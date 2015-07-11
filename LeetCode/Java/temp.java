import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  /**
   * @param head: The head of linked list
   */
  public int partitionArray(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int small = 0;
    int equal = 0;
    int great = 0;
    for (int num: nums) {
      small += num < k ? 1 : 0;
      equal += num == k ? 1 : 0;
      great += num > k ? 1 : 0;
    }
    int i = 0;
    int si = 0;
    int ei = small;
    int gi = small + equal;
    while (i < nums.length) {
      if (nums[i] < k) {
        if (i >= small) {
          swap(nums, i, si);
          si++;
        } else {
          i++;
        }
      } else if (nums[i] > k) {
        if (i < equal + small) {
          swap(nums, i, gi);
          gi++;
        } else {
          i++;
        }
      } else {
        if (i >= small && i < equal + small) {
          i++;
        } else {
          swap(nums, i, ei);
          ei++;
        }
      }
    }
    return small;
  }

  private void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }





  public static void main(String[] args) {
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {9,9,9,8,9,8,7,9,8,8,8,9,8,9,8,8,6,9};
    int result = new temp().partitionArray(A, 9);
    System.out.println(result);
  }
}

