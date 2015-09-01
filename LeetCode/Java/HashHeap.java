import java.util.*;

/**
 * Created by YiLIU on 8/30/15.
 */
public class HashHeap {
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

  public static Comparator<Integer> maxCmp = new Comparator<Integer>() {

    @Override
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  };

  public static void main(String[] args) {
    int[] arr = {2,7,26,25,19,17,1,90,3,36};
    HashHeap heap = new HashHeap("MAX");
    PriorityQueue<Integer> standard = new PriorityQueue<>(maxCmp);

    for (int num: arr) {
      heap.offer(num);
      standard.offer(num);
      System.out.println(heap.peek() == standard.peek());
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(heap.poll() == standard.poll());
    }
  }
}
