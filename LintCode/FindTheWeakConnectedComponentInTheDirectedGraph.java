/**
 * Find the Weak Connected Component in the Directed Graph
 * http://www.lintcode.com/en/problem/find-the-weak-connected-component-in-the-directed-graph/
 *
 * Find the number Weak Connected Component in the directed graph. Each node in the graph contains a label and a list of its neighbors.
 * (a connected set of a directed graph is a subgraph in which any two vertices are connected by direct edge path.)
 *
 * Example
 * Given graph:
 *   A------>B  C
 *    \      |  |
 *     \     |  |
 *      \    |  |
 *       \   v  v
 *        -> D  E <- F
 *
 * Return {A, B, D}, {C, E, F}. Since there are two connected components which are {A, B, D} and {C, E, F}.
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
   * @param nodes a array of Directed graph node
   * @return a connected set of a directed graph
   */
  public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
    // Write your code here
    if (nodes == null || nodes.size() == 0) {
      return new ArrayList<>();
    }

    HashSet<Integer> labels = new HashSet<>();
    for (DirectedGraphNode node: nodes) {
      labels.add(node.label);
    }

    UnionFind uf = new UnionFind(labels);

    for (DirectedGraphNode ori: nodes) {
      for (DirectedGraphNode neighbor: ori.neighbors) {
        uf.union(ori.label, neighbor.label);
      }
    }

    return uf.print();
  }

  private class UnionFind {
    HashMap<Integer, Integer> father;
    UnionFind(HashSet<Integer> nums) {
      father = new HashMap<>();
      for (int n: nums) {
        father.put(n, n);
      }
    }

    int compressedFind(int node) {
      int fa = father.get(node);
      while (fa != father.get(fa)) {
        fa = father.get(fa);
      }

      int fat = father.get(node);
      while (fat != father.get(fat)) {
        int temp = father.get(fat);
        father.put(fat, fa);
        fat = temp;
      }

      return fa;
    }

    void union (int a, int b) {
      int aFa = compressedFind(a);
      int bFa = compressedFind(b);
      if (aFa != bFa) {
        father.put(bFa, aFa);
      }
    }

    List<List<Integer>> print() {
      HashMap<Integer, ArrayList<Integer>> sameFa = new HashMap<>();
      List<List<Integer>> result = new ArrayList<>();

      for (int n: father.keySet()) {
        int f = compressedFind(n);
        if (!sameFa.containsKey(f)) {
          sameFa.put(f, new ArrayList<Integer>());
        }
        sameFa.get(f).add(n);
      }

      for (List<Integer> list: sameFa.values()) {
        Collections.sort(list);
        result.add(list);
      }

      return result;
    }
  }
}

