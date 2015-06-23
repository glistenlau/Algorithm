import java.util.*;

/**
 * Created by yi on 5/7/15.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {
        Map<UndirectedGraphNode, UndirectedGraphNode> maps = new HashMap<>();
        return DFS(node, maps);
    }

    private UndirectedGraphNode DFS(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (map.containsKey(graph)) return map.get(graph);
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
        map.put(graph, graphCopy);
        for (UndirectedGraphNode neighbor : graph.neighbors) {
            graphCopy.neighbors.add(DFS(neighbor, map));
        }
        return graphCopy;
    }

    public UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> maps = new HashMap<>();
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
        maps.put(node, graphCopy);
        Queue<UndirectedGraphNode> nodeList = new ArrayDeque<>();
        nodeList.add(node);
        while (!nodeList.isEmpty()) {
            UndirectedGraphNode execNode = nodeList.poll();
            for (UndirectedGraphNode neighbor : execNode.neighbors) {
                if (maps.containsKey(neighbor)) {
                    maps.get(execNode).neighbors.add(maps.get(neighbor));
                } else {
                    maps.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    maps.get(execNode).neighbors.add(maps.get(neighbor));
                }
                nodeList.add(neighbor);
            }
        }
        return graphCopy;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
