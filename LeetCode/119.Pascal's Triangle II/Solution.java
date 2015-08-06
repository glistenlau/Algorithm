public class Solution {
  public List<Integer> getRow(int numRows) {
    List<Integer> curt = new ArrayList<Integer>();
    List<Integer> prev = new ArrayList<Integer>();
    for (int i = 1; i <= numRows + 1; i++) {
      curt = new ArrayList<Integer>();
      if (i > 1) {

        for (int j = 0; j <= prev.size(); j++) {
          if (j == 0 || j == prev.size()) {
            curt.add(1);
          } else {
            curt.add(prev.get(j - 1) + prev.get(j));
          }
        }

      } else {
        curt.add(1);
      }
      prev = curt;
    }

    return curt;
  }
}