import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 有n个点，［0，1，2］，输出序列为：［0，1，2，1，0，2，0］ 满足： 0->1, 1->0,
 * 0->2, 2->0, 1->2, 2->1， 求得最短输出序列。
 *
 * This problem can be converted to a graph problem, every vertex has the one-direction edges to
 * the other vertex, for example for [0, 1, 2], we have
 * 0 -> 1, 0 -> 2
 * 1 -> 0, 1 -> 2
 * 2 -> 0, 2 -> 1
 * we can start from 0, 0 -> 1 -> 2 -> 0 -> 2 -> 1 -> 0
 * because every vertex has two entry edges and two exit edges, so it can not have duplicate paths.
 */
public class ShortestSequence {
  private class GraphNode {
    int val;
    ArrayList<GraphNode> neighbors;

    GraphNode(int val) {
      this.val = val;
      neighbors = new ArrayList<>();
    }
  }

  private List<GraphNode> generateGraph(int[] arr) {
    List<GraphNode> graphs = new ArrayList<>();
    for (int num: arr) {
      graphs.add(new GraphNode(num));
    }

    for (GraphNode node: graphs) {
      for (GraphNode neighbor: graphs) {
        if (neighbor == node) {
          continue;
        }
        node.neighbors.add(neighbor);
      }
    }

    return graphs;
  }

  public List<Integer> shortestSequence(int[] points) {
    if (points == null || points.length == 0) {
      return new ArrayList<>();
    }

    List<GraphNode> graphs = generateGraph(points);

    List<Integer> ans = new ArrayList<>();


    GraphNode node = graphs.get(0);
    while (!node.neighbors.isEmpty()) {
      node = search(node, points.length, ans, new HashSet<>());
    }
    ans.add(graphs.get(0).val);

    return ans;
  }

  private GraphNode search(GraphNode node, int n, List<Integer> ans, HashSet<GraphNode> visited) {
    if (n == 0) {
      return node;
    }

    if (visited.contains(node)) {
      return null;
    }

    ans.add(node.val);
    visited.add(node);

    for (int i = 0; i < node.neighbors.size(); i++) {
      GraphNode neighbor = node.neighbors.get(i);
      GraphNode next = search(neighbor, n - 1, ans, visited);
      node.neighbors.remove(neighbor);
      if (next != null) {
        return next;

      }
      node.neighbors.add(neighbor);
    }

    visited.remove(node);
    ans.remove(ans.size() - 1);

    return null;
  }

  public static void main(String[] args) {
    System.out.println(new ShortestSequence().shortestSequence(new int[]{0, 1, 2, 3, 4, 5, 6}));
  }
}
