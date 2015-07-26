public class Solution {
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> result = new ArrayList<List<String>>();
    int[] pos = new int[n];

    DFS(n, pos, 0, result);
    return result;
  }

  private void DFS(int n, int[] pos, int row, List<List<String>> result) {
    if (row == n) {
      result.add(generatePatern(pos));
      return;
    }

    for (int col = 0; col < n; col++) {
      if (checkValid(pos, row, col)) {
        pos[row] = col;
        DFS(n, pos, row + 1, result);
      }
    }
  }

  private List<String> generatePatern(int[] pos) {
    List<String> result = new ArrayList<String>();

    int n = pos.length;
    for (int i = 0; i < n; i++) {
      StringBuilder temp = new StringBuilder(n);
      for (int j = 0; j < n; j++) {
        if (j == pos[i]) {
          temp.append('Q');
        } else {
          temp.append('.');
        }
      }
      result.add(temp.toString());
    }
    return result;
  }

  private boolean checkValid(int[] pos, int row, int col) {
    for (int i = 0; i < row; i++) {
      if (pos[i] == col) {
        return false;
      } else {
        if (Math.abs(row - i) == Math.abs(col - pos[i])) {
          return false;
        }
      }
    }
    return true;
  }
}