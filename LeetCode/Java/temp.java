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
  public int maxSubArray(ArrayList<Integer> nums, int k) {
    if (nums == null || nums.size() < k) {
      return 0;
    }

    int[][] localMax = new int[k + 1][nums.size() + 1];
    int[][] globalMax = new int[k + 1][nums.size() + 1];

    for (int i = 1; i <= k; i++) {
      localMax[i][i - 1] = Integer.MIN_VALUE;
    }

    for (int i = 1; i <= k; i++) {
      for (int j = i; j <= nums.size(); j++) {
        localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1] ) + nums.get(j - 1);
        if (j == i) {
          globalMax[i][j] = localMax[i][j];
        } else {
          globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
        }
      }
    }
    return globalMax[k][nums.size()];
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
    int[] A = {-1,-2,-3,-100,-1,-50};
    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    int result = new temp().maxSubArray(B, 3);
    System.out.println(result);
  }
}

