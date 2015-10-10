import java.util.*;
import java.util.stream.Stream;

/**
 * 第一题Moving Average.很简单，题目说给的是一个stream,求前K个数的平均值
 */
public class KStreamMean {
  public List<Integer> kStreamMean(Stream<Integer> s, int k) {
    List<Integer> ans = new ArrayList<>();
    Deque<Integer> dq = new LinkedList<Integer>();
    Iterator<Integer> itor = s.iterator();
    int sum = 0;
    while (itor.hasNext()) {
      int temp = itor.next();
      dq.addLast(temp);
      sum += temp;
      if (dq.size() == k) {
        sum -= dq.removeFirst();
        ans.add(sum / k);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    List<Integer> test = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    System.out.println(new KStreamMean().kStreamMean(test.stream(), 3));
  }

}
