/**
 * Clone Graph
 * http://www.lintcode.com/en/problem/clone-graph/
 *
 * Clone an undirected graph. Each node in the graph contains a label and a
 * list of its neighbors.
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  /**
   * @param node: A undirected graph node
   * @return: A undirected graph node
   */
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    // write your code here
    if (node == null) {
      return null;
    }
    Queue<UndirectedGraphNode> myQueue = new LinkedList<UndirectedGraphNode>();
    HashMap<UndirectedGraphNode, UndirectedGraphNode> lookup = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
    myQueue.offer(node);

    while(!myQueue.isEmpty()) {
      UndirectedGraphNode curt = myQueue.poll();
      if (visited.contains(curt)) {
        continue;
      }
      visited.add(curt);
      if (!lookup.containsKey(curt)) {
        lookup.put(curt, new UndirectedGraphNode(curt.label));
      }
      for (UndirectedGraphNode neighbor: curt.neighbors) {
        if (!lookup.containsKey(neighbor)) {
          lookup.put(neighbor, new UndirectedGraphNode(neighbor.label));
        }
        myQueue.offer(neighbor);
      }
    }

    for(UndirectedGraphNode getNode: visited) {
      for (UndirectedGraphNode neighbor: getNode.neighbors) {
        lookup.get(getNode).neighbors.add(lookup.get(neighbor));
      }
    }
    return lookup.get(node);
  }
}


