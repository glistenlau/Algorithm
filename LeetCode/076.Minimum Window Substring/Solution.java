public class Solution {
  public String minWindow(String Source, String Target) {
    String minRst = "";
    int[] targetTable = new int[256];
    int srcNum = 0;
    int start = 0;
    int resLen = Integer.MAX_VALUE;
    int tarNum = getTargetTable(targetTable, Target);

    for (int i = 0; i < Source.length(); i++) {
      if (targetTable[Source.charAt(i)] > 0) {
        srcNum++;
      }
      targetTable[Source.charAt(i)]--;

      while (srcNum >= tarNum) {
        if (resLen > i - start + 1) {
          resLen = i - start + 1;
          minRst = Source.substring(start, i + 1);
        }

        if (++targetTable[Source.charAt(start)] > 0) {
          srcNum--;
        }
        start++;
      }

    }

    return minRst;
  }

  private int getTargetTable(int[] targetTable, String Target) {
    int tarNum = 0;
    for (char c: Target.toCharArray()) {
      targetTable[c]++;
      tarNum++;
    }

    return tarNum;
  }
}