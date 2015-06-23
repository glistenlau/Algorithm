/**
 * Created by YiLIU on 6/12/15.
 */
public class ZigZagConversion {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    StringBuilder result = new StringBuilder();
    boolean falling = true;
    int n = s.length();
    int count = 0;
      for (int i = 0; i < numRows; ++i) {
        while (count < n) {
          result.append(s.charAt(count));
          if (i == 0) {
            count += (numRows - i - 1) * 2;
          } else if (i == numRows - 1) {
            count += i * 2;
          } else {
            count += falling ? (numRows - i - 1) * 2 : i * 2;
            falling = !falling;
          }
        }
        count = i + 1;
        falling = true;
      }
    return result.toString();
  }

  public static void main (String[] args) {
    System.out.println(new ZigZagConversion().convert("ABCDE", 4));
  }
}
