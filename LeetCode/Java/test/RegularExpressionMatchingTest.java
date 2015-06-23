import org.junit.Assert;
import org.junit.Test;


/**
 * Created by YiLIU on 6/14/15.
 */
public class RegularExpressionMatchingTest {

  @Test
  public void testIsMatch() throws Exception {
    RegularExpressionMatching test = new RegularExpressionMatching();
    Assert.assertEquals(false, test.isMatch("aa", "a"));
    Assert.assertEquals(true, test.isMatch("aa", "aa"));
    Assert.assertEquals(false, test.isMatch("aaa", "aa"));
    Assert.assertEquals(true, test.isMatch("aa", "a*"));
    Assert.assertEquals(true, test.isMatch("aa", ".*"));
    Assert.assertEquals(true, test.isMatch("ab", ".*"));
    Assert.assertEquals(true, test.isMatch("aab", "c*a*b"));
    Assert.assertEquals(false, test.isMatchR("aa", "a"));
    Assert.assertEquals(true, test.isMatchR("aa", "aa"));
    Assert.assertEquals(false, test.isMatchR("aaa", "aa"));
    Assert.assertEquals(true, test.isMatchR("aa", "a*"));
    Assert.assertEquals(true, test.isMatchR("aa", ".*"));
    Assert.assertEquals(true, test.isMatchR("ab", ".*"));
    Assert.assertEquals(true, test.isMatchR("aab", "c*a*b"));
    Assert.assertEquals(false, test.isMatchR("a", "ab*a"));
    Assert.assertEquals(false, test.isMatchR("a", "ab*a"));
  }
}