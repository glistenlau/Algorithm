public class Solution {
  public String largestNumber(int[] nums) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length, digitComp);
    for (int num: nums) {
      maxHeap.offer(num);
    }

    StringBuilder result = new StringBuilder();
    while (!maxHeap.isEmpty()) {
      if (result.toString().equals("0") && maxHeap.peek() == 0) {
        break;
      }
      result.append(maxHeap.poll());
    }
    return result.toString();
  }

  private Comparator<Integer> digitComp = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
      if (a == b) {
        return 0;
      }
      String aStr = String.valueOf(a);
      String bStr = String.valueOf(b);
      int len = Math.max(aStr.length(), bStr.length());
      int aIndex = 0;
      int bIndex = 0;

      while (aIndex < aStr.length() || bIndex < bStr.length()) {
        aIndex = aIndex == aStr.length()? 0 : aIndex;
        bIndex = bIndex == bStr.length()? 0 : bIndex;
        if (aStr.charAt(aIndex++) != bStr.charAt(bIndex++)) {
          break;
        }
      }

      return bStr.charAt(bIndex - 1) - aStr.charAt(aIndex - 1);
    }
  };
}