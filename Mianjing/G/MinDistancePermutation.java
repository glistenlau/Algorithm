import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输出任意permutation使得List中的相同element的间距要大于minDistance。
 * For example:
 * input: [B, E, A, C, D, E, F], 2
 * output: [B, F, A, C, D, E, F]
 *
 * 这题可以先把所有字母的频率统计出来，根据频率放入heap中，然后每次把频率最高的k个放在数组中，这样任意相同的两个元素之间的距离都
 * 不会小于minDistance。这样做的原因是频率大的元素它占的空间越多，必须要先满足它的要求，如果优先排频率大的要求不能满足, 那别的
 * 排列方法一定满足不了，因为一定没有空间给频率大的元素。
 */
public class MinDistancePermutation {
  private class Node{
    char val;
    int count;
    Node(char val, int count) {
      this.val = val;
      this.count = count;
    }
  }

  public char[] minDistancePermutation(char[] characters, int minDistance) {
    if (characters == null || characters.length == 0) {
      return new char[0];
    }

    HashMap<Character, Integer> freq = new HashMap<>();
    for (char c: characters) {
      if (!freq.containsKey(c)) {
        freq.put(c, 0);
      }

      freq.put(c, freq.get(c) + 1);
    }

    PriorityQueue<Node> maxHeap = new PriorityQueue<>(
        (ch1, ch2) -> ch1.count == ch2.count? ch2.val - ch1.val: ch2.count - ch1
            .count);

    for(char c: freq.keySet()) {
      maxHeap.offer(new Node(c, freq.get(c)));
    }

    int index = 0;
    while (!maxHeap.isEmpty()) {
      Queue<Node> myQ = new LinkedList<>();
      int i = 0;
      for ( ; i < minDistance && !maxHeap.isEmpty(); i++) {
        myQ.offer(maxHeap.poll());
      }

      if (i < minDistance && myQ.peek().count > 1) {
        return null;
      }

      while (!myQ.isEmpty()) {
        Node cur = myQ.poll();
        characters[index++] = cur.val;
        if (--cur.count != 0) {
          maxHeap.offer(cur);
        }
      }
    }

    return characters;
  }


  public static void main(String[] args) {
    char[] chars = {'A', 'A', 'B', 'B', 'C', 'C'};
    System.out.println(new MinDistancePermutation().minDistancePermutation(chars, 2));
  }
}
