public class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");

    int result =  getResult(v1, v2, 0);
    if (result < 0) {
      return -1;
    }
    if (result > 0) {
      return 1;
    }
    return 0;
  }

  private int getResult(String[] v1, String[] v2, int pos) {
    if (v1.length <= pos && v2.length <= pos) {
      return 0;
    }
    int ver1 = v1.length > pos? Integer.parseInt(v1[pos]): 0;
    int ver2 = v2.length > pos? Integer.parseInt(v2[pos]): 0;

    if (ver1 == ver2) {
      return getResult(v1, v2, pos + 1);
    }
    return ver1 - ver2;
  }
}