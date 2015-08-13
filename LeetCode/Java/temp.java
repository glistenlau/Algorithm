import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
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
      int aFather = parent.get(a);
      int bFather = parent.get(b);
      if (aFather != bFather) {
        parent.put(b, aFather);
      }
    }

    List<List<Integer>> print() {
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      HashMap<Integer, List<Integer>> connected = new HashMap<>();
      for (int i: parent.keySet()) {
        if (!connected.containsKey(parent.get(i))) {
          connected.put(parent.get(i), new ArrayList<>());
        }
        connected.get(parent.get(i)).add(i);
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



  public static void main(String[] args) {
    String[] temp = {"cat", "cats", "and", "sand", "dog"};

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"O"};
    char[][] board = new char[strA.length][strA[0].length()];
    int i = 0;
    for (String str: strA) {
      board[i++] = str.toCharArray();
    }

    char[][] sodoku = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    int[] A = {1, 2, 7, 8, 5};
    int[][] matrix1 = {{1, 2, 3, 6, 5}, {16, 41, 23, 22, 6}, {15, 17, 24, 21, 7}, {14, 18, 19, 20, 10}, {13, 14, 11, 10, 9}};

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    TreeLinkNode tln = new TreeLinkNode(1);
    tln.left = new TreeLinkNode(2);
    tln.right = new TreeLinkNode(3);
    tln.left.left = new TreeLinkNode(4);
    tln.left.right = new TreeLinkNode(5);
    tln.right.right = new TreeLinkNode(7);


    List<Interval> test = new ArrayList<>();
    test.add(new Interval(1, 2));
    test.add(new Interval(3, 5));
    test.add(new Interval(6, 7));
    test.add(new Interval(8, 10));
    test.add(new Interval(12, 16));
    Queue<Set<String>> myQueue = new LinkedList<>();

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    boolean check = dict.contains("hot");
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int[] pre = {1, 2, 5, 6, 3, 7, 8};
    int[] in = {5, 2, 6, 1, 7, 3, 8};
    int[] post = {5, 6, 2, 7, 8, 3, 1};
    new temp().wordBreak("catsanddog", dict);


    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println();
  }
}

