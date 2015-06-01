import java.util.HashMap;

/**
 * Created by YiLIU on 5/31/15.
 */
public class AvoidRoads {
  public long numWays(int width, int height, String[] bad) {
    HashMap<String, String> block = new HashMap<>();
    if (width == 0 && height == 0) return 0;
    int n = bad.length;
    long[][] numPath = new long[width + 1][height + 1];

    for (int i = 0; i < n; ++i) {
      String blockSrc = bad[i].substring(0, 3);
      String blockDes = bad[i].substring(4, 7);
      String[] spl = bad[i].split(" ");
      if (Integer.parseInt(spl[0]) + Integer.parseInt(spl[1]) <
          Integer.parseInt(spl[2]) + Integer.parseInt(spl[3])) {
        block.put(blockDes, blockSrc);
      } else {
        block.put(blockSrc, blockDes);
      }
    }
    numPath[0][0] = 1;

    for (int i = 0; i <= width; ++i) {
      for (int j = 0; j <= height; ++j) {
        String tar = "" + i + " " + j;
        if (i == 0 && j == 0) continue;
        if (block.containsKey(tar)) {
          String[] spl = block.get(tar).split(" ");
          int badW = Integer.parseInt(block.get(tar).split(" ")[0]);
          int badH = Integer.parseInt(block.get(tar).split(" ")[1]);

          if (i - 1 >= 0 && i - 1 != badW && j != badH) {
            numPath[i][j] = numPath[i - 1][j];
          } else if (j - 1 >= 0 && i != badW && j - 1 != badH) {
            numPath[i][j] = numPath[i][j - 1];
          } else {
            numPath[i][j] = 0;
          }

          continue;
        }
        numPath[i][j] = (i - 1 >= 0 ? numPath[i - 1][j] : 0) +
            (j - 1 >= 0 ? numPath[i][j - 1] : 0);
      }
    }
    return numPath[width][height];
  }

  public static void main (String[] args) {
    int width = 6;
    int height = 6;
    String[] bad = {"0 0 0 1", "6 6 5 6"};
    System.out.println(new AvoidRoads().numWays(width, height, bad));
  }

}
