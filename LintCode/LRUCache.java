/**
 * LRU Cache
 * www.lintcode.com/en/problem/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used(LRU) cache.
 * It should support the following operations: get and set.
 *
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 *
 * set(key, value) - Set or insert the value if the key is not already
 * present. When the cache reached its capacity, it should invalidate the
 * least recently used item before inserting a new item.
 */

public class Solution {

  // @param capacity, an integer
  private class doubleList {
    int key;
    int val;
    doubleList prev;
    doubleList next;
    public doubleList(int key, int val) {
      this.key = key;
      this.val = val;
      prev = null;
      prev = next;
    }
  }

  doubleList head;
  doubleList tail;

  public Solution(int capacity) {
    head = new doubleList(-1, 0);
    tail = new doubleList(-1, capacity);
  }

  public int get(int key) {
    if (head.val == 0) {
      return -1;
    }
    doubleList curt = tail;
    while (curt.prev != head) {
      if (curt.prev.key == key) {
        if (curt.prev.next != tail) {
          doubleList temp = curt.prev;
          curt.prev = curt.prev.prev;
          curt.prev.next = curt;
          temp.prev = tail.prev;
          temp.next = tail;
          tail.prev.next = temp;
          tail.prev = temp;
        }
        return tail.prev.val;
      }
      curt = curt.prev;
    }
    return -1;
  }

  public void set(int key, int value) {
    if (head.val == 0) {
      head.next = new doubleList(key, value);
      head.next.prev = head;
      head.next.next = tail;
      tail.prev = head.next;
      head.val++;
      return;
    }
    int v = get(key);
    if (v != -1) {
      tail.prev.val = value;
    } else {
      if (head.val == tail.val) {
        deleteLeast();
        insertRecent(key, value);
      } else {
        insertRecent(key, value);
      }
    }
  }

  private void insertRecent(int key, int val) {
    doubleList temp = new doubleList(key, val);
    temp.prev = tail.prev;
    temp.next = tail;
    tail.prev.next = temp;
    tail.prev = temp;
    head.val++;
  }

  private void deleteLeast() {
    head.next = head.next.next;
    head.next.prev = head;
    head.val--;
  }
}

