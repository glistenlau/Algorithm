/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) {
      return null;
    }

    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    Queue<UndirectedGraphNode> myQ = new LinkedList<>();
    myQ.offer(node);

    while(!myQ.isEmpty()) {
      UndirectedGraphNode curt = myQ.poll();
      map.put(curt, new UndirectedGraphNode(curt.label));
      for (UndirectedGraphNode neighbor: curt.neighbors) {
        if (!map.containsKey(neighbor)) {
          myQ.offer(neighbor);
        }
      }
    }

    for (UndirectedGraphNode ori: map.keySet()) {
      for (UndirectedGraphNode neighbor: ori.neighbors) {
        map.get(ori).neighbors.add(map.get(neighbor));
      }
    }

    return map.get(node);
  }
}