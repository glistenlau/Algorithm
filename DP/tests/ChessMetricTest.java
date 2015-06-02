import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YiLIU on 6/2/15.
 */
public class ChessMetricTest {

  @Test
  public void testHowMany() throws Exception {
    ChessMetric testClass = new ChessMetric();
    int[] size = {3, 3, 3, 3, 100, 8, 8, 3, 10, 13, 13, 100, 100, 100, 100, 100, 3, 3};
    int[][] start = {{0, 0}, {0, 0}, {0, 0}, {0, 0}, {0, 0}, {4, 4}, {2, 3}, {0, 0}, {5, 5}, {3, 7},
        {3, 7}, {0, 0}, {0, 0}, {99, 99}, {99, 99}, {99, 99}, {0, 2}, {0, 2}};
    int[][] end = {{1, 0}, {1, 2}, {2, 2}, {0, 0}, {0, 99}, {4, 4}, {7, 7}, {2, 2},
        {9, 9}, {11, 5}, {11, 5}, {50, 50}, {50, 50}, {0, 0}, {0, 0}, {0, 0}, {2, 0}, {0, 0}};
    int[] numMove = {1, 1, 1, 2, 50, 6, 9, 20, 4, 4, 14, 35, 34, 50, 50, 50, 1, 1};
    long[] result = {1, 1, 0, 5, 243097320072600L, 246460, 69232032, 979171322101760L, 133, 4, 96417727286208L, 480451056515520L, 485001159390L, 0, 0, 0, 0, 0};
    Assert.assertEquals(size.length, start.length, end.length);
    Assert.assertEquals(size.length, numMove.length, result.length);

    for(int i = 0; i < size.length; ++i) {
      Assert.assertEquals(testClass.howMany(size[i], start[i], end[i], numMove[i]), result[i]);
    }

  }
}