/**
 * Topological Sorting
 * http://www.lintcode.com/en/problem/topological-sorting/
 *
 * Given an directed graph, a topological order of the graph nodes is defined
 * as follow:
 *   For each directed edge A->B in graph, A must before B in the order list.
 *   The first node in the order can be any node in the graph with no nodes
 *   direct to it.
 * Find any topological order for the given graph.
 */

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
  /**
   * @param graph: A list of Directed graph node
   * @return: Any topological order for the given graph.
   */
  public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    // write your code herer
    ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
    HashMap<DirectedGraphNode, Integer> lookup = new HashMap<DirectedGraphNode, Integer>();
    if (graph == null) {
      return result;
    }
    for (DirectedGraphNode node: graph) {
      for(DirectedGraphNode neighbor: node.neighbors) {
        if (lookup.containsKey(neighbor)) {
          lookup.put(neighbor, lookup.get(neighbor) + 1);
        } else {
          lookup.put(neighbor, 1);
        }
      }
    }
    Queue<DirectedGraphNode> myQueue = new LinkedList<DirectedGraphNode>();
    for (DirectedGraphNode node: graph) {
      if (!lookup.containsKey(node)) {
        myQueue.offer(node);
        result.add(node);
      }
    }

    while(!myQueue.isEmpty()) {
      DirectedGraphNode curt = myQueue.poll();
      for (DirectedGraphNode neighbor: curt.neighbors) {
        lookup.put(neighbor, lookup.get(neighbor) - 1);
        if (lookup.get(neighbor) == 0) {
          myQueue.offer(neighbor);
          result.add(neighbor);
        }
      }
    }
    return result;
  }
}
