/**
 * Sliding Window Median
 * www.lintcode.com/en/problem/sliding-window-median/
 *
 * Given an array of n integers, and moving window(size k), move the window at each
 * iteration from the start of the array, find the median of the element inside the
 * window at each moving. (If there are even numbers in the array, return the N/2-th
 * number after sorting the element in the window.)
 *
 * Example
 * For array [1, 2, 7, 8, 5], moving window size k = 3. return [2, 7, 7] At first the
 * window is at the start of the array like this [|1, 2, 7|, 8, 5], return the median 2;
 * then the window move one step forward.
 * [1, |2, 7, 8|, 5], return the median 7; then the window move one step forward again.
 * [1, 2, |7, 8, 5|], return the median 7;
 */
public class Solution {
  /**
   * @param nums: A list of integers.
   * @return: The median of the element inside the window at each moving.
   */
  private class Node {
    int index, val;
    Node(int index, int val) {
      this.index = index;
      this.val = val;
    }
  }
  public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
    // write your code here
    ArrayList<Integer> result = new ArrayList<>();
    if (nums == null || nums.length == 0 || k == 0) {
      return result;
    }
    Queue<Node> maxHeap = new PriorityQueue<>(nums.length, maxComp);
    Queue<Node> minHeap = new PriorityQueue<>(nums.length, minComp);
    Node[] nodes = new Node[nums.length];
    Node median = null;

    for (int i = 0; i < nums.length; i++) {
      nodes[i] = new Node(i, nums[i]);
      if (median == null) {
        median = nodes[i];
      } else if (nums[i] < median.val) {
        maxHeap.offer(nodes[i]);
      } else {
        minHeap.offer(nodes[i]);
      }

      while (maxHeap.size() > minHeap.size()) {
        minHeap.offer(median);
        median = maxHeap.poll();
      }
      while (minHeap.size() > maxHeap.size() + 1) {
        maxHeap.offer(median);
        median = minHeap.poll();
      }

      if (i >= k - 1) {
        result.add(median.val);
        if (median.index == i - k + 1) {
          if (maxHeap.isEmpty() && minHeap.isEmpty()) {
            median = null;
          } else {
            median = maxHeap.size() > minHeap.size()? maxHeap.poll(): minHeap.poll();
          }
        } else {
          maxHeap.remove(nodes[i - k + 1]);
          minHeap.remove(nodes[i - k + 1]);
        }
      }
    }

    return result;
  }

  private Comparator<Node> maxComp = new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
      return b.val - a.val;
    }
  };

  private Comparator<Node> minComp = new Comparator<Node>() {
    @Override
    public int compare(Node a, Node b) {
      return a.val - b.val;
    }
  };
}

