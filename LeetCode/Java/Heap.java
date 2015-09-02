import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by YiLIU on 8/30/15.
 */
public class Heap {
  List<Integer> heap;
  String mode;

  Heap (String mode) {
    this.heap = new ArrayList<>();
    this.mode = mode;
  }

  void offer(int num) {
    heap.add(num);
    siftUp(heap.size() - 1);
  }

  int peek() {
    return heap.get(0);
  }

  int poll() {
    swap(0, heap.size() - 1);
    int ans = heap.get(heap.size() - 1);
    heap.remove(heap.size() - 1);
    siftDown(0);
    return ans;
  }

  void delete(int num) {
    int i = 0;
    for ( ; i < heap.size(); i++) {
      if (heap.get(i) == num) {
        break;
      }
    }

    swap(i, heap.size() - 1);
    heap.remove(heap.size() - 1);
    siftDown(i);
  }

  void siftUp(int index) {
    if (index == 0) {
      return;
    }

    int parent = getParent(index);
    if (parent != -1 && !isGood(parent, index)) {
      swap(index, parent);
      siftUp(parent);
    }
  }

  void siftDown(int index) {
    if (index >= heap.size()) {
      return;
    }

    int lChild = getLChild(index);
    int rChild = getRChild(index);
    int child = -1;

    if (lChild != -1 && rChild != -1) {
      child = isGood(lChild, rChild)? lChild: rChild;
    } else if (lChild != -1) {
      child = lChild;
    } else if (rChild != -1) {
      child = rChild;
    }

    if (child != -1 && !(isGood(index, child))) {
      swap(index, child);
      siftDown(child);
    }
  }

  boolean isGood(int parent, int child) {
    if (mode == "MAX") {
      return heap.get(parent) >= heap.get(child);
    } else {
      return heap.get(parent) <= heap.get(child);
    }
  }

  void swap(int a, int b) {
    int temp = heap.get(a);
    heap.set(a, heap.get(b));
    heap.set(b, temp);
  }

  int getParent(int index) {
    if (index == 0) {
      return -1;
    }

    return (index - 1) / 2;
  }

  int getLChild(int index) {
    int left = 2 * index + 1;
    if (left < heap.size()) {
      return left;
    }

    return -1;
  }

  int getRChild(int index) {
    int right = 2 * index + 2;
    if (right < heap.size()) {
      return right;
    }

    return -1;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("./LeetCode/java/log.txt"));
    br.readLine();
    Scanner in = new Scanner(System.in);
    Heap test = new Heap("MAX");
    int size = in.nextInt();
    for (int i = 0; i < size; i++) {
      test.offer(in.nextInt());
    }
    new ArrayList<>(Arrays.asList(new int[]{1, 2}));
    System.out.println(test.peek());
    System.out.println(test.poll());
    test.delete(in.nextInt());
    System.out.println(test.peek());

  }
}
