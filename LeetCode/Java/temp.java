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
  public int threeSumClosest(int[] numbers, int target) {
    if (numbers == null || numbers.length < 3) {
      return 0;
    }
    Arrays.sort(numbers);
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < numbers.length; i++) {
      int left = i + 1;
      int right = numbers.length - 1;
      while (left < right) {
        int sum = numbers[i] + numbers[left] + numbers[right];
        min = Math.abs(sum - target) < Math.abs(min - target) ? sum : min;
        if (sum == target) {
          return target;
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return min;
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
    int[] A = {1,0,-1,-1,-1,-1,0,1,1,1,2};
    int result = new temp().threeSumClosest(A, 7);
    System.out.println(result);
  }
}

