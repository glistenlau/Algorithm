import java.util.Scanner;

/**
 * Created by YiLIU on 9/1/15.
 */
public class StringPower {
  public int StringPower(String A, String B) {
    if (A.length() > B.length()) {
      return 0;
    }
    int n = B.length() / A.length();

    int left = 0;
    int right = n;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (isValid(A, B, mid)) {
        left = mid;
      } else {
        right = mid;
      }
    }

    if (isValid(A, B, right)) {
      return right;
    }
    return left;
  }

  private boolean isValid(String A, String B, int k) {
    int index = 0;
    for (int i = 0; i < A.length(); i++) {
      for (int j = 0; j < k; j++) {
        while (index < B.length() && A.charAt(i) != B.charAt(index)) {
          index++;
        }
        if (index == B.length()) {
          return false;
        }
        index++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(new StringPower().StringPower("XYZ", "XXadhflakjhelXXzzqqkkpoYYadadfhgakheZafhajkefhlZadhflkejhZfagjhfebhh"));
  }
  Scanner in = new Scanner(System.in);
  int n = in.nextInt();
}
