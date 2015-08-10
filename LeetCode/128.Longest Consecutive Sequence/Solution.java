public class Solution {
  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    HashSet<Integer> map = new HashSet<Integer>();
    for (int n: nums) {
      map.add(n);
    }

    int longest = 0;
    for (int n: nums) {
      if (!map.contains(n)) {
        continue;
      }
      int count = 1;
      int temp = n - 1;
      while(map.contains(temp)) {
        map.remove(temp);
        temp--;
        count++;
      }
      temp = n + 1;
      while (map.contains(temp)) {
        map.remove(temp);
        temp++;
        count++;
      }
      map.remove(n);
      longest = Math.max(longest, count);
    }

    return longest;
  }
}