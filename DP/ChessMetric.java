/**
 * Created by YiLIU on 6/1/15.
 */
public class ChessMetric {
  public long howMany(int size, int[] start, int[] end, int numMove) {
    final int[] stepX = {-1, -1, -1, 0, 0, 1, 1, 1, -2, -2, 2, 2, -1, 1, -1, 1};
    final int[] stepY = {-1, 0, 1, -1, 1, -1, 0, 1, -1, 1, -1, 1, -2, -2, 2, 2};

    long[][][] maxStep = new long[size][size][numMove + 1];
    maxStep[start[0]][start[1]][0] = 1;

    for (int n = 1; n <= numMove; ++n) {
      for (int i = 0; i < size; ++i) {
        for (int j = 0; j < size; ++j) {
          for (int k = 0; k < stepX.length; ++k) {
            int nX = i + stepX[k];
            int nY = j + stepY[k];
            if (nX >=0 && nX < size && nY >= 0 && nY < size) {
              maxStep[nX][nY][n] += maxStep[i][j][n - 1];
            }
          }
        }
      }
    }
    return maxStep[end[0]][end[1]][numMove];
 }

  public static void main(String[] args) {
    int size = 8;
    int[] start = {2, 3};
    int[] end = {7, 7};
    int numMove = 9;
    System.out.println(new ChessMetric().howMany(size, start, end, numMove));
  }
}
