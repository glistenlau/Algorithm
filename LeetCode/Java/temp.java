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
  public int maxTwoSubArrays(ArrayList<Integer> nums) {
    if (nums == null || nums.size() == 0) {
      return 0;
    }
    int[] first = findMax(nums, 0, nums.size());
    int[] left = findMax(nums, 0, first[1] + 1);
    int[] right = findMax(nums, first[2] + 1, nums.size());
    return first[0] + Math.max(left[0], right[0]);
  }

  private int[] findMax(ArrayList<Integer> nums, int start, int end) {

    int[] result = new int[3];
    if (end - start == 0) {
      return result;
    }
    int[] sum = new int[end - start];
    sum[start] = nums.get(start);
    for (int i = 1; i < end - start; i++) {
      sum[i] = sum[i - 1] + nums.get(i);
    }

    int min = 0;
    int max = Integer.MIN_VALUE;
    int minIndex = -1;
    int maxIndex = 0;
    for (int i = 0; i < end - start; i++) {
      if (sum[i] - min > max) {
        max = sum[i] - min;
        maxIndex = i;
      }
      if (sum[i] < min) {
        min = sum[i];
        minIndex = i;
      }
    }
    result[0] = max;
    result[1] = minIndex;
    result[2] = maxIndex;
    return result;
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
    int[] A = {1,3,-1,2,-1,2};
    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    int result = new temp().maxTwoSubArrays(B);
    System.out.println(result);
  }
}

