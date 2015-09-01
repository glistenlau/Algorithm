/**
 * Building Outline
 * www.lintcode.com/en/problem/building-outline/
 *
 * Given N buildings in a x-axis, each building is a rectangle and can be represented
 * by a triple(start, end, height), where start is the start position on x-axis, end
 * is the end position on x-axis and height is the height of the building. Buildings
 * may overlap if you see them form far away, find the outline of them.
 *
 * An outline can be represented by a triple, (start, end, height), where start is the
 * start position on x-axis of the outline, end the end position on x-axis and height
 * is the height of the outline.
 *
 * Example
 * Given 3 builidings:
 * [
 *   [1, 3, 3],
 *   [2, 4, 4],
 *   [5, 6, 1]
 * ]
 *
 * The outline are:
 * [
 *   [1, 2, 3],
 *   [2, 4, 4],
 *   [5, 6, 1]
 * ]
 */

public class Solution {
  /**
   * @param buildings: A list of lists of integers
   * @return: Find the outline of those buildings
   */

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
      this.remove(ans);
      size--;
      return ans;
    }

    void remove(int num) {
      Node node = map.get(num);
      int index = node.index;
      if (node.num == 1) {
        swap(node.index, heap.size() - 1);
        map.remove(num);
        heap.remove(heap.size() - 1);
        siftUp(index);
        siftDown(index);
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
      if (index >= heap.size()) {
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
        heap.remove(e.h);
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
      }
      if (e1.isEnd && e2.isEnd) {
        return e1.h - e2.h;
      }
      if (!e1.isEnd && !e2.isEnd) {
        return e2.h - e1.h;
      }
      return !e1.isEnd? -1: 1;
    }
  };

  private Comparator<Integer> maxCmp = new Comparator<Integer>() {
    @Override
    public int compare(Integer a, Integer b) {
      return b - a;
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
}

