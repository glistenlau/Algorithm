import java.util.*;

/**
 * InterleavingIterator Flatten 2D Vector 变种 ，输入不再是List<List<>>而是List<Iterator>，遍历顺序也变成了先遍历每一个list的第n个元素
 * 比如 说 <1,2,3><4, 5, 6><7, 8>
 * 要返回的是<1, 4, 7, 2, 5, 8, 3, 6>
 *
 * 解题思路是把所有有hasNext 的Iterator加入队列，并把没有队列中没有hasNext的移出队列， 如果队列为空则hasNext为false；
 */
public class InterleavingIterator implements Iterator {
  Queue<Iterator> queue = new LinkedList<>();

  InterleavingIterator(List<Iterator> iters) {
    for (Iterator iter: iters) {
      if (iter.hasNext()) {
        queue.offer(iter);
      }
    }
  }


  @Override
  public boolean hasNext() {
    return !queue.isEmpty();
  }

  @Override
  public Object next() {
    Iterator cur = queue.poll();
    Object ans = cur.next();

    if(cur.hasNext()) {
      queue.offer(cur);
    }

    return ans;
  }

  public static void main(String[] args) {
    List<Iterator> test1 = new ArrayList<>(Arrays.asList(Arrays.asList(1, 2, 3).iterator(),
        Arrays.asList(4, 5, 6).iterator(), Arrays.asList(7, 8).iterator()));
    InterleavingIterator iter = new InterleavingIterator(test1);
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
  }
}

