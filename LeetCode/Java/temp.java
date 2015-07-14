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
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
      int[] leftMax = new int[nums.size()];
      int[] leftMin = new int[nums.size()];
      int[] rightMax = new int[nums.size()];
      int[] rightMin = new int[nums.size()];

      int sum = 0;
      int minSum = 0;
      int maxSum = 0;
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int i = 0; i < nums.size(); i++) {
        sum += nums.get(i);
        max = Math.max(max, sum - minSum);
        min = Math.min(min, sum - maxSum);
        maxSum = Math.max(sum, maxSum);
        minSum = Math.min(sum, minSum);
        leftMax[i] = max;
        leftMin[i] = min;
      }

      sum = 0;
      minSum = 0;
      maxSum = 0;
      min = Integer.MAX_VALUE;
      max = Integer.MIN_VALUE;
      for (int i = nums.size() - 1; i >= 0; i--) {
        sum += nums.get(i);
        max = Math.max(max, sum - minSum);
        min = Math.min(min, sum - maxSum);
        maxSum = Math.max(sum, maxSum);
        minSum = Math.min(sum, minSum);
        rightMax[i] = max;
        rightMin[i] = min;
      }

      max = -1;
      for (int i = 0; i < nums.size() - 1; i++) {
        max = Math.max(max, Math.abs(leftMax[i] - rightMin[i + 1]));
        max = Math.max(max, Math.abs(leftMin[i] - rightMax[i + 1]));
      }
      return max;
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
    int[] A = {1, 2, -3, 1};
    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    int result = new temp().maxDiffSubArrays(B);
    System.out.println(result);
  }
}

