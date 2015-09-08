/**
 * Route Between Two Nodes in Graph
 * www.lintcode.com/en/problem/route-between-two-nodes-in-graph/
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
  /**
   * @param graph: A list of Directed graph node
   * @param s: the starting Directed graph node
   * @param t: the terminal Directed graph node
   * @return: a boolean value
   */
  public boolean hasRoute(ArrayList<DirectedGraphNode> graph, DirectedGraphNode s, DirectedGraphNode t) {
    if (graph == null || graph.size() == 0) {
      return false;
    }

    if (s == t) {
      return true;
    }

    Queue<DirectedGraphNode> route = new LinkedList<>();
    HashSet<DirectedGraphNode> visited = new HashSet<>();

    for (DirectedGraphNode node: graph) {
      if (node == s) {
        route.offer(node);
        visited.add(node);
      }
    }

    while (!route.isEmpty()) {
      DirectedGraphNode cur = route.poll();
      for (DirectedGraphNode neighbor: cur.neighbors) {
        if (!visited.contains(neighbor)) {
          if (neighbor == t) {
            return true;
          }
          route.offer(neighbor);
          visited.add(neighbor);
        }
      }
    }

    return false;
  }
}
