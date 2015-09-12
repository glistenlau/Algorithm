import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目是binary watch：上边是小时，下边是分钟，最左边最significant，最右边为1。给你数字n，return所有可能的时间，以string为表达形式
 * E.G. 给你1,那return:{1:00,2:00,4:00,8:00,0:01.........}
 */
public class BinaryWatch {
  public List<String> binaryWatch(int n) {
    if (n == 0) {
      return new ArrayList<>(Arrays.asList("0:00"));
    }

    List<String> ans = new ArrayList<>();
    dfsHelper(n, 0, 0, ans);

    return ans;
  }

  private void dfsHelper(int n, int hour, int minute, List<String> ans) {
    if (n == 0) {
      ans.add("" + hour + ":" + (minute < 10? "0": "" )+ minute);
      return;
    }

    for (int i = 0; i < 4; i++) {
      if (((hour >> i) & 1) == 1) {
        continue;
      }
      hour |= (1 << i);
      if (hour < 12) {
        dfsHelper(n - 1, hour, minute, ans);
      }
      hour &= ((1 << 5) - 1) - (1 << i);
    }

    for (int i = 0; i < 6; i++) {
      if (((minute >> i) & 1) == 1) {
        continue;
      }

      minute |= (1 << i);
      if (minute < 60) {
        dfsHelper(n - 1, hour, minute, ans);
      }
      minute &= ((1 << 7) - 1) - (1 << i);
    }
  }

  public static void main(String[] args) {
    System.out.println(new BinaryWatch().binaryWatch(3));
  }
}
