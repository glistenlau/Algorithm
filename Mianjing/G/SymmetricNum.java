import java.util.*;

/**
 * 假设定义两个数字串symmetric: 数字串翻转后和以前一样。例如：101和1001，翻转后依然是自己。同时如果2翻转后变成5，5翻转后变成2，
 * 6和9互相翻转，0，1和8翻转后是自己，别的数字(3,4,7)翻转后无效。例如12翻转后是51，71翻转后无效。给定一个n，求所有长度为n的翻转
 */
public class SymmetricNum {
  public ArrayList<String> symmetricNum(int n) {
    if (n <= 0) {
      return new ArrayList<>();
    }

    int[] map = new int[]{0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
    HashMap<Integer, Integer> sym = new HashMap<>();
    HashMap<Integer, Integer> unsym = new HashMap<>();
    Queue<String> ans = new LinkedList<>();

    for (int i = 0; i < map.length; i++) {
      if (map[i] == -1) {
        continue;
      }
      if (map[i] == i) {
        sym.put(i, i);
      }
      if (map[i] != i) {
        unsym.put(i, map[i]);
      }
    }
    if (n % 2 == 0) {
      ans.offer("");
      midExpand(ans, n, sym, unsym);
    } else {
      for (int num: sym.values()) {
        ans.add("" + num);
      }
      midExpand(ans, n - 1, sym, unsym);
    }


    return new ArrayList<>(ans);
  }

  private void midExpand(Queue<String> ans, int n, HashMap<Integer, Integer> sym, HashMap<Integer, Integer> unsym) {
    if (n == 0) {
      return;
    }

    int size = ans.size();
    for (int i = 0; i < size; i++) {
      String cur = ans.poll();
      for (int num: sym.values()) {
        ans.offer("" + num + cur + num);
      }
      for (int key: unsym.keySet()) {
        ans.offer("" + unsym.get(key) + cur + key);
      }
    }

    midExpand(ans, n - 2, sym, unsym);
  }

  public static void main(String[] args) {
    System.out.println(new SymmetricNum().symmetricNum(4));
  }
}
