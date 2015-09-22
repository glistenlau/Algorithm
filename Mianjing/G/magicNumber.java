import java.util.ArrayList;
import java.util.List;

/**
 * Created by YiLIU on 9/21/15.
 */
public class magicNumber {
  public int magicNumber(int n) {
    if (n <= 0) {
      return 0;
    }
    List<Integer> ans = new ArrayList<Integer>();
    ans.add(0);

    int pow = 0;
    for (; n > 0; pow++) {
      int size = ans.size();
      int cur = (int)Math.pow(5, pow);
      for (int i = 0; i < size; i++) {
        int next = cur + ans.get(i);
        if (--n == 0) {
          return next;
        }
        ans.add(next);
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    System.out.println(new magicNumber().magicNumber(7));
  }
}
