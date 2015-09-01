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
  private class HashHeap {
    class Node{
      int num, index;
      Node(int num, int index) {
        this.num = num;
        this.index = index;
      }
    }

    int size;
    String mode;
    List<Integer> heap;
    HashMap<Integer, Node> map;

    HashHeap(String mode) {
      this.size = 0;
      this.mode = mode;
      this.heap = new ArrayList<>();
      this.map = new HashMap<>();
    }

    void offer(int num) {
      if (map.containsKey(num)) {
        map.get(num).num++;
      } else {
        heap.add(num);
        map.put(num, new Node(1, heap.size() - 1));
        siftUp(heap.size() - 1);
      }
      size++;
    }

    int peek() {
      return heap.get(0);
    }

    int poll() {
      int ans = this.peek();
      this.delete(ans);
      size--;
      return ans;
    }

    void delete(int num) {
      Node node = map.get(num);
      if (node.num == 1) {
        swap(node.index, heap.size() - 1);
        map.remove(num);
        heap.remove(heap.size() - 1);
        siftUp(node.index);
        siftDown(node.index);
      } else {
        node.num--;
      }
      size--;
    }

    boolean isEmpty() {
      return size == 0;
    }

    void swap(int a, int b) {
      if (a == b) {
        return;
      }

      Node nodeA = map.get(heap.get(a));
      Node nodeB = map.get(heap.get(b));

      int temp = nodeA.index;
      nodeA.index = nodeB.index;
      nodeB.index = temp;

      temp = heap.get(a);
      heap.set(a, heap.get(b));
      heap.set(b, temp);
    }

    void siftUp(int index) {
      if (index == 0 || index >= heap.size()) {
        return;
      }

      int parent = getParent(index);
      if (parent != -1 && !isGood(parent, index)) {
        swap(parent, index);
        siftUp(parent);
      }
    }

    void siftDown(int index) {
      if (index == 0 || index >= heap.size()) {
        return;
      }

      int lChild = getLeftChild(index);
      int rChild = getRightChild(index);
      int child = -1;

      if (lChild != -1 && rChild != -1) {
        child = isGood(lChild, rChild)? lChild: rChild;
      } else if (lChild != -1) {
        child = lChild;
      } else if (rChild != -1) {
        child = rChild;
      }

      if (child != -1 && !isGood(index, child)) {
        swap(index, child);
        siftDown(child);
      }
    }

    int getParent(int index) {
      if (index == 0) {
        return -1;
      }

      return (index - 1) / 2;
    }

    int getLeftChild(int index) {
      int left = 2 * index + 1;
      if (left >= heap.size()) {
        return -1;
      }

      return left;
    }

    int getRightChild(int index) {
      int right = 2 * index + 2;
      if (right >= heap.size()) {
        return -1;
      }

      return right;
    }

    boolean isGood(int parent, int child) {
      if (mode == "MAX") {
        return heap.get(parent) >= heap.get(child);
      } else {
        return heap.get(parent) <= heap.get(child);
      }
    }

  }

  private class Edge{
    int pos, h;
    boolean isEnd;

    Edge(int pos, int h, boolean isEnd) {
      this.pos = pos;
      this.h = h;
      this.isEnd = isEnd;
    }
  }

  public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
    // write your code here
    if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
      return new ArrayList<>();
    }

    HashHeap heap = new HashHeap("MAX");
    Edge[] edges = new Edge[2 * buildings.length];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    int i = 0;
    for (int[] building: buildings) {
      edges[i++] = new Edge(building[0], building[2], false);
      edges[i++] = new Edge(building[1], building[2], true);
    }

    Arrays.sort(edges, edgeCmp);

    for (Edge e: edges) {
      if (e.isEnd) {
        heap.delete(e.h);
        if (heap.isEmpty() || e.h > heap.peek()) {
          ArrayList<Integer> temp = new ArrayList<>();
          temp.add(e.pos);
          temp.add(heap.isEmpty()? 0: heap.peek());
          ans.add(temp);
        }
      } else {
        if (heap.isEmpty() || e.h > heap.peek()) {
          ArrayList<Integer> temp = new ArrayList<>();
          temp.add(e.pos);
          temp.add(e.h);
          ans.add(temp);
        }
        heap.offer(e.h);
      }
    }

    return getResult(ans);
  }

  private Comparator<Edge> edgeCmp = new Comparator<Edge>() {
    @Override
    public int compare(Edge e1, Edge e2) {
      if (e1.pos != e2.pos) {
        return e1.pos - e2.pos;
      } else if (e1.h != e2.h) {
        if (e1.isEnd && e2.isEnd) {
          return e1.h - e2.h;
        } else if (!e1.isEnd && !e2.isEnd) {
          return e2.h - e1.h;
        } else {
          return 0;
        }
      } else {
        return 0;
      }
    }
  };

  private ArrayList<ArrayList<Integer>> getResult(ArrayList<ArrayList<Integer>> ans) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    int prePos = ans.get(0).get(0);;
    int preH = ans.get(0).get(1);

    for (int i = 1; i < ans.size(); i++) {
      int curPos = ans.get(i).get(0);
      int curH = ans.get(i).get(1);
      if (preH != 0) {
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(prePos);
        temp.add(curPos);
        temp.add(preH);
        result.add(temp);
      }
      prePos = curPos;
      preH = curH;

    }

    return result;
  }

  public static void main(String[] args) {
    String[] temp = {"oath", "pea", "eat", "rain"};
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'o', 'f', 'l', 'v'}
    };

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"1 + 1", " 2-1 + 2", "(1 + (4+5+2)-3) + (6+8)"};
    int i = 0;


    char[][] sodoku = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    int[] A = {1, 2, 3, 4, 5};
    int[][] matrix1 = {{4,67,187},{3,80,65},{49,77,117},{67,74,9},{6,42,92},{48,67,69},{10,13,58},{47,99,152},{66,99,53},{66,71,34},{27,63,2},{35,81,116},{47,49,10},{68,97,175},{20,33,53},{24,94,20},{74,77,155},{39,98,144},{52,89,84},{13,65,222},{24,41,75},{16,24,142},{40,95,4},{6,56,188},{1,38,219},{19,79,149},{50,61,174},{4,25,14},{4,46,225},{12,32,215},{57,76,47},{11,30,179},{88,99,99},{2,19,228},{16,57,114},{31,69,58},{12,61,198},{70,88,131},{7,37,42},{5,48,211},{2,64,106},{49,73,204},{76,88,26},{58,61,215},{39,51,125},{13,38,48},{74,99,145},{4,12,8},{12,33,161},{61,95,190},{16,19,196},{3,84,8},{5,36,118},{82,87,40},{8,44,212},{15,70,222},{16,25,176},{9,100,74},{38,78,99},{23,77,43},{45,89,229},{7,84,163},{48,72,1},{31,88,123},{35,62,190},{21,29,41},{37,97,81},{7,49,78},{83,84,132},{33,61,27},{18,45,1},{52,64,4},{58,98,57},{14,22,1},{9,85,200},{50,76,147},{54,70,201},{5,55,97},{9,42,125},{31,88,146}};

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
//    Point[] pts= {new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};
//
//    ListNode head = new ListNode(4);
//    head.next = new ListNode(3);
//    head.next.next = new ListNode(1);
//    head.next.next.next = new ListNode(5);
//    head.next.next.next.next = new ListNode(2);
    boolean check = dict.contains("hot");
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int[] pre = {1, 2, 5, 6, 3, 7, 8};
    int[] in = {5, 2, 6, 1, 7, 3, 8};
    int[] post = {5, 6, 2, 7, 8, 3, 1};
    ArrayList<Interval> quries = new ArrayList<>();
    quries.add(new Interval(1, 2));
    quries.add(new Interval(0, 4));
    quries.add(new Interval(2, 4));
    int[] col = new int[1000];

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    System.out.println(new temp().buildingOutline(matrix1));
  }
}

