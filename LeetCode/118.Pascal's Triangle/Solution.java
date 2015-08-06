public class Solution {
  public List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (numRows < 1) {
      return result;
    }

    for (int i = 1; i <= numRows; i++) {
      List<Integer> level = new ArrayList<Integer>();

      if (i > 1) {

        for (int j = 0; j <= result.get(i - 2).size(); j++) {
          if (j == 0 || j == result.get(i - 2).size()) {
            level.add(1);
          } else {
            level.add(result.get(i - 2).get(j - 1) + result.get(i - 2).get(j));
          }
        }

      } else {
        level.add(1);
      }

      result.add(new ArrayList<Integer>(level));
    }

    return result;
  }
}