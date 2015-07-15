/**
 * Binary Representation
 * www.lintcode.com/en/problem/binary-representation/
 *
 * Given a (decimal - e.g. 3.72) number that is passed in as string, return
 * the binary representation that is passed in as a string. If the number can
 * not be represented accurately in binary with at most 32 characters, return
 * ERROR.
 *
 * Example
 * For n = "3.72", return "ERROR".
 * For n = "3.5", return "11.1".
 */

public class Solution {
  /**
   *@param n: Given a decimal number that is passed in as a string
   *@return: A string
   */
  public String binaryRepresentation(String n) {
    if (n == null || n.length() == 0) {
      return "ERROR";
    }

    StringBuilder intStr = new StringBuilder();
    StringBuilder decStr = new StringBuilder();
    double decPart = Double.parseDouble(n.substring(n.indexOf('.')));

    while(decPart > 0.0) {
      if (decStr.length() > 31) {
        return "ERROR";
      }
      decPart *= 2.0;
      if (decPart >= 1.0) {
        decStr.append(1);
        decPart -= 1.0;
      } else {
        decStr.append(0);
      }
    }
    int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
    while (intPart > 0) {
      intStr.insert(0, intPart % 2);
      intPart /= 2;
    }

    if (intStr.length() == 0 && decStr.length() == 0) {
      return "0";
    }
    if (decStr.length() == 0) {
      return intStr.toString();
    } else if (intStr.length() == 0) {
      return "0" + "." + decStr.toString();
    } else {
      return intStr.toString() + "." + decStr.toString();
    }
  }
}
