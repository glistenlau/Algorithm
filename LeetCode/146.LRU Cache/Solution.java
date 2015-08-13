public class LRUCache {
  private class DoublyListNode {
    int value, key;
    DoublyListNode prev, next;
    DoublyListNode(int key, int value) {
      this.key = key;
      this.value = value;
      this.prev = this.next = null;
    }
  }

  DoublyListNode start, end;
  HashMap<Integer, DoublyListNode> map;

  public LRUCache(int capacity) {
    map = new HashMap<>();
    start = end = new DoublyListNode(0, capacity);
    start.next = end;
    end.prev = start;
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    DoublyListNode curt = map.get(key);
    curt.prev.next = curt.next;
    curt.next.prev = curt.prev;
    insertToEnd(curt);
    return curt.value;
  }

  public void set(int key, int value) {
    if (map.containsKey(key)) {
      this.get(key);
      map.get(key).value = value;
      return;
    }

    if (start.value <= 0) {
      DoublyListNode least = start.next;
      start.next = least.next;
      least.next.prev = start;
      least.next = least.prev = null;
      map.remove(least.key);
    } else {
      start.value--;
    }
    DoublyListNode newNode = new DoublyListNode(key, value);
    insertToEnd(newNode);
    map.put(key, newNode);
  }

  private void insertToEnd(DoublyListNode node) {
    node.prev = end.prev;
    node.next = end;
    end.prev.next = node;
    end.prev = node;
  }
}