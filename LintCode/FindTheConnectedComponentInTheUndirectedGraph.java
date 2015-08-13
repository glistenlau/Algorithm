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

      Collections.sort(connected);
      result.add(connected);
    }

    return result;
  }
}

// Solution 2: Union Find
public class Solution {
  private class UnionFind {
    HashMap<Integer, Integer> parent;

    UnionFind(HashSet<Integer> nodes) {
      parent = new HashMap<>();
      for (int num: nodes) {
        parent.put(num, num);
      }
    }

    int compressedFind(int node) {
      int father = parent.get(node);
      while (father != parent.get(father)) {
        father = parent.get(father);
      }
      int fa = parent.get(node);
      while (fa != parent.get(fa)) {
        int temp = parent.get(fa);
        parent.put(fa, father);
        fa = temp;
      }

      return father;
    }

    void union(int a, int b) {
      int aFather = this.compressedFind(a);
      int bFather = this.compressedFind(b);
      if (aFather != bFather) {
        parent.put(bFather, aFather);
      }
    }

    List<List<Integer>> print() {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      HashMap<Integer, ArrayList<Integer>> connected = new HashMap<>();
      for (int i: parent.keySet()) {
        int father = this.compressedFind(i);
        if (!connected.containsKey(father)) {
          connected.put(father, new ArrayList<Integer>());
        }
        connected.get(father).add(i);
      }

      for (List<Integer> list: connected.values()) {
        Collections.sort(list);
        result.add(list);
      }

      return result;
    }
  }


  public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
    if (nodes == null) {
      return new ArrayList<>();
    }

    HashSet<Integer> nodeSet = new HashSet<>();
    for (UndirectedGraphNode node: nodes) {
      nodeSet.add(node.label);
    }

    UnionFind uf = new UnionFind(nodeSet);

    for (UndirectedGraphNode node: nodes) {
      for (UndirectedGraphNode neighbor: node.neighbors) {
        int nodeFather = uf.compressedFind(node.label);
        int neighborFather = uf.compressedFind(neighbor.label);
        if (nodeFather != neighborFather) {
          uf.union(node.label, neighbor.label);
        }
      }
    }

    return uf.print();
  }
}

