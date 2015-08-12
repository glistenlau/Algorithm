/**
 * Find the Connected Component in the Undirected Graph
 * http://www.lintcode.com/en/problem/find-the-connected-component-in-the-undirected-graph/
 *
 * Find the number connected component in the undirected graph. Each node in the graph contains a label and list of
 * its neightbors. (a connected component(or just component) of an undirected graph is a subgraph in which any two
 * vertices are connected to each other by paths, and which is connected to no additional verices in the supergraph.)
 *
 * Example
 * Given graph:
 *
 *   A------B  C
 *    \     |  |
 *     \    |  |
 *      \   |  |
 *       \  |  |
 *         D   E
 *
 * Return {A, B, D}, {C, E}. Since there are two connected component which is {A, B, D}, {C, E}.
 */

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Solution 1: BFS
public class Solution {
  /**
   * @param nodes a array of Undirected graph node
   * @return a connected set of a Undirected graph
   */
  public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
    // Write your code here
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (nodes == null) {
      return result;
    }

    HashSet<UndirectedGraphNode> visited = new HashSet<>();
    Queue<UndirectedGraphNode> myQ = new LinkedList<>();

    for (UndirectedGraphNode node: nodes) {
      if (visited.contains(node)) {
        continue;
      }

      List<Integer> connected = new ArrayList<>();
      myQ.offer(node);
      visited.add(node);

      while (!myQ.isEmpty()) {
        UndirectedGraphNode curt = myQ.poll();
        connected.add(curt.label);

        for (UndirectedGraphNode neighbor: curt.neighbors) {
          if (visited.contains(neighbor)) {
            continue;
          }
          myQ.offer(neighbor);
          visited.add(neighbor);
        }

      }
      result.add(connected);
    }

    return result;
  }
}
