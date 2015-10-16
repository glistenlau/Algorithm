import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个图，节点表示城市，有M个节点和M-1条边，所以是没有环的，用一个array表示这个图，比如T[x]=y的话那么节点
 * x,y相连，如果T[x]=x就说明x是首都。现在要分别求出到首都距离为1，2，3…M-1的节点数。
 */
public class DistanceFromCapital {
  public int[] distanceFromCapital(int[] graph) {
    if (graph == null || graph.length == 0) {
      return new int[0];
    }

    int[] ans = new int[graph.length - 1];

    int capital = -1;

    for (int i = 0; i < graph.length; i++) {
      if (graph[i] == i) {
        capital = i;
        break;
      }
    }

    if (capital == -1) {
      return ans;
    }

    Queue<Integer> level = new LinkedList<>();
    level.offer(capital);
    int levels = 0;

    while (!level.isEmpty()) {
      int size = level.size();
      for (int i = 0; i < size; i++) {
        int cur = level.poll();
        for (int j = 0; j < graph.length; j++) {
          if (j != cur && graph[j] == cur) {
            level.offer(j);
          }
        }
      }

      ans[levels++] = level.size();
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(new DistanceFromCapital().distanceFromCapital(new int[]{2, 4, 3, 3, 5, 3})));
  }

}
