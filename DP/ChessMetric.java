import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by YiLIU on 6/1/15.
 */
public class ChessMetric {
  public long howMany(int size, int[] start, int[] end, int numMove) {
    Queue<int[]> orderStep = new ArrayDeque<>();
    orderStep.add(start);
    int[] possibleStep = new int[numMove + 1];
    long[][] maxStep = new long[size][size];
    possibleStep[0] = 1;

    for (int n = 1; n <= numMove;) {
      if (possibleStep[n - 1] == 0) {
        ++n;
        continue;
      }
      int[] current = orderStep.remove();
      possibleStep[n - 1]--;
      int x = current[0];
      int y = current[1];

      for (int i = -2; i <= 2; ++i) {
        for (int j = -2; j <= 2; ++j) {
          if ((i == -2 || i == 2) && (j != -1 && j != 1) ||
              (j == -2 || j == 2) && (i != -1 && i != 1))
            continue;
          if (i == 0 && j == 0) continue;
          if (x + i >= 0 && y + j >= 0 && x + i <= size - 1 && y + j <= size - 1) {
            int[] valid = {x + i, y + j};
            maxStep[x + i][y + j]++;
            orderStep.add(valid);
            possibleStep[n]++;
          }
        }
      }
    }
    return maxStep[end[0]][end[1]];
  }

  public static void main(String[] args) {
    int size = 100;
    int[] start = {0, 0};
    int[] end = {0, 99};
    int numMove = 50;
    System.out.println(new ChessMetric().howMany(size, start, end, numMove));
  }
}
