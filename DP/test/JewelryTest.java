import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YiLIU on 6/2/15.
 */
public class JewelryTest {

  @Test
  public void testHowMany() throws Exception {
    Jewelry test = new Jewelry();
    int[][] value = {{1, 2, 5, 3, 4, 5},
        {1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000,
            1000, 1000, 1000, 1000, 1000},
        {1, 2, 3, 4, 5},
        {7, 7, 8, 9, 10, 11, 1, 2, 2, 3, 4, 5, 6},
        {123, 217, 661, 678, 796, 964, 54, 111, 417, 526, 917, 923}};

  /*  Assert.assertEquals(9, test.howMany(value[0]));
    Assert.assertEquals(18252025766940L, test.howMany(value[1]));
    Assert.assertEquals(4, test.howMany(value[2]));
    Assert.assertEquals(607, test.howMany(value[3]));
    Assert.assertEquals(0, test.howMany(value[4]));
*/
  }
}