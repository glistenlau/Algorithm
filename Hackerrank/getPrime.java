import java.util.ArrayList;

/**
 * Created by YiLIU on 8/19/15.
 */
public class getPrime {
  public int getprime(int n) {


    ArrayList<Integer> nums = new ArrayList<Integer>();
    for (int i = 2; i <= n; i++) {
      nums.add(i);
    }

    int i = 0;
    while (i < nums.size()) {
      int num = nums.get(i);
      int j = i + 1;
      while (j < nums.size()) {
        if (nums.get(j) % num == 0) {
          nums.remove(j);
        } else {
          j++;
        }

      }
      i++;
    }

    return nums.size();
  }

  public static void main(String[] args) {
    int test = new getPrime().getprime(1000000);
    System.out.println(test);
  }
}
