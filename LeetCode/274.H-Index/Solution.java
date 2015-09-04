public class Solution {
  public int hIndex(int[] citations) {
    if (citations == null || citations.length == 0) {
      return 0;
    }

    int[] count = new int[citations.length + 1];
    for (int c: citations) {
      if (c > citations.length) {
        count[count.length - 1]++;
      } else {
        count[c]++;
      }
    }

    int bigger = 0;
    int ans = 0;
    for (int i = count.length - 1; i >= 0; i--) {
      bigger += count[i];
      if (bigger >= i) {
        ans = i;
        break;
      }
    }

    return ans;
  }
}