import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Give two numbers represented by string, return the sum of the two numbers
 *
 * The idea is to do the sum from the least significant bit to the most significant bit.
 */
public class StringSum {
  public String stringSum(String num1, String num2) {
    if (num1 == null && num2 == null) {
      return "";
    } else if (num1 == null) {
      return num2;
    } else if (num2 == null) {
      return num1;
    }

    int index1 = num1.length() - 1;
    int index2 = num2.length() - 1;

    StringBuilder ans = new StringBuilder();
    int carry = 0;

    while (index1 >= 0 && index2 >= 0) {
      int sum = num1.charAt(index1--) - '0' + num2.charAt(index2--) - '0' + carry;
      carry = sum / 10;
      ans.insert(0, sum % 10);
    }
    while (index1 >= 0) {
      int sum = num1.charAt(index1--) - '0' + carry;
      carry = sum / 10;
      ans.insert(0, sum % 10);
    }
    while (index2 >= 0) {
      int sum = num2.charAt(index2--) - '0' + carry;
      carry = sum / 10;
      ans.insert(0, sum % 10);
    }
    if (carry != 0) {
      ans.insert(0, carry);
    }

    return ans.toString();
  }

  /**
   * Follow up: If the string is very long, how can you speed the sum.
   *
   * The idea is to divide the string to many parts to do the sum parallel, and then combine
   * together. But the carry should be considered. Because the carry can be 0 or 1, so we can do
   * two sum for each part, one is carry equals 0 and another is carry equals to 1, and int the
   * final combination, if the previous part's carry is 1, pick the sum calculated for carry is
   * one, if the carry is 0, pick another result.
   */

  public String bigStringSum(String num1, String num2) {
    if (num1 == null && num2 == null) {
      return "";
    } else if (num1 == null) {
      return num2;
    } else if (num2 == null) {
      return num1;
    }


    List<String> numList = new ArrayList<>();
    int n = Math.max(num1.length(), num2.length());
    for (int i = 0; i < n; i += 100) {
      int e = i + (i + 100 <= n? 100: n - i);
      numList.add((i < num1.length()? num1.substring(i, e > num1.length()? num1.length(): e):
          "") + "#" + (i < num2.length()? num2.substring(i, e > num2.length()? num2.length(): e):
          ""));
    }

    String ans = numList.parallelStream()
        .map(num -> {
          String[] nums = num.split("#");
          return stringSum(nums[0], nums[1], 0) + stringSum(nums[0], nums[1], 1);
        })
        .reduce("0#0", (sum, num) -> {
          String[] sums = sum.split("#");
          String[] nums = num.split("#");

          if (sums[1].equals("0")) {
            return sums[0] + nums[0] + "#" + nums[1];
          } else {
            return sums[0] + nums[2] + "#" + nums[3];
          }
        });

    String[] rst = ans.split("#");
    if (rst[1].equals("0")) {
      return rst[0];
    } else {
      return rst[1] + rst[0];
    }
  }

  private String stringSum(String n1, String n2, int carry) {
    StringBuilder rst = new StringBuilder();
    int index1 = n1.length() - 1;
    int index2 = n2.length() - 1;

    while (index1 >= 0 && index2 >= 0) {
      int sum = n1.charAt(index1--) - '0' + n2.charAt(index2--) - '0' + carry;
      carry = sum / 10;
      rst.insert(0, sum % 10);
    }
    while (index1 >= 0) {
      int sum = n1.charAt(index1--) - '0' + carry;
      carry = sum / 10;
      rst.insert(0, sum % 10);
    }
    while (index2 >= 0) {
      int sum = n2.charAt(index2--) - '0' + carry;
      carry = sum / 10;
      rst.insert(0, sum % 10);
    }
    rst.append("#" + carry + "#");

    return rst.toString();
  }


  public static void main(String[] args) {
    System.out.println(new StringSum().bigStringSum(
        "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
        +
            "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999",
        "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999" +
            "999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"
    ));
  }
}
