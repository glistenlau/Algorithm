import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by YiLIU on 6/5/15.
 */
public class MaximumSumSubarrayTest {

  @Test
  public void testMaxSubArray() throws Exception {
    int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    Assert.assertEquals(6, new MaximumSumSubarray().maxSubArray(test));
  }
}