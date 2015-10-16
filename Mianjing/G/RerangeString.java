import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 1. 印度女生，虽然是印度的，但女生还是比较友善的。题目大致是BACCBBAAA -> ABABACABC，就是输出相邻字母不能相同的string，这题要用到heap
 */
public class RerangeString {
  class CharFreq {
    char value;
    int count;
    CharFreq (char value, int count) {
      this.value = value;
      this.count = count;
    }
  }

  public String rearrangeString(String str) {
    if (str == null || str.length() == 0) {
      return str;
    }

    HashMap<Character, Integer> map = new HashMap<>();

    for (int i = 0; i < str.length(); i++) {
      char cur = str.charAt(i);
      if (!map.containsKey(cur)) {
        map.put(cur, 0);
      }
      map.put(cur, map.get(cur) + 1);
    }

    PriorityQueue<CharFreq> heap = new PriorityQueue<>((o1, o2)-> {
      if (o1.count != o2.count) {
        return o2.count - o1.count;
      } else {
        return o1.value - o2.value;
      }
    });

    for (char c: map.keySet()) {
      heap.offer(new CharFreq(c, map.get(c)));
    }

    StringBuilder ans = new StringBuilder();
    CharFreq pre = null;

    while (!heap.isEmpty()) {
      CharFreq cur = heap.poll();
      ans.append(cur.value);
      cur.count -= 1;
      if (pre != null && pre.count > 0) {
        heap.offer(pre);
      }
      pre = cur;
    }

    if (pre.count > 0) {
      return "";
    } else {
      return ans.toString();
    }
  }


  public static void main(String[] args) {
    System.out.println(new RerangeString().rearrangeString("BACCBBAAAAA"));
  }


}
