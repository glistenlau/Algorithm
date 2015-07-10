import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  /**
   * @param head: The head of linked list
   */
  public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    List<List<String>> result = new ArrayList<List<String>>();
    HashMap<String, Integer> lookup = buildLevel(end, start, dict);
    Stack<String> myStack = new Stack<String>();
    List<String> single = new ArrayList<String>();
    myStack.push(start);
    while(!myStack.isEmpty()) {
      String curt = myStack.pop();
      single.add(curt);
      int level = lookup.get(curt);
      for (int i = 0; i < curt.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          String replace = curt.substring(0, i) + Character.toString(c) + curt.substring(i + 1, curt.length());
          if (replace.equals(end)) {
            single.add(replace);
            result.add(new ArrayList(single));
            if (!myStack.isEmpty()) {
              for (int j = 0; i < lookup.get(myStack.peek()); i++) {
                single.remove(single.size() - 1);
              }
            } else {
              return result;
            }
          }

          if (!dict.contains(replace) || lookup.get(replace) >= level) {
            continue;
          } else {
            myStack.push(replace);
          }
        }
      }
    }
    return result;
  }

  private HashMap<String, Integer> buildLevel(String start, String end, Set<String> dict) {
    HashMap<String, Integer> result = new HashMap<String, Integer>();
    Set<String> copy = new HashSet<String>(dict);
    Queue<String> myQueue = new LinkedList<String>();
    myQueue.offer(start);
    copy.remove(start);
    int level = 0;
    while (!myQueue.isEmpty()) {
      int size = myQueue.size();
      for (int n = 0; n < size; n++) {
        String curt = myQueue.poll();
        for (int i = 0; i < curt.length(); i++) {
          for (char c = 'a'; c <= 'z'; c++) {
            String replace = curt.substring(0, i) + Character.toString(c) + curt.substring(i + 1, curt.length());
            if (replace.equals(end)) {
              return result;
            }
            if (!copy.contains(replace)) {
              continue;
            } else {
              result.put(replace, level + 1);
              myQueue.add(replace);
              copy.remove(replace);
            }
          }
        }
        level += 1;
      }
    }
    return result;
  }





  public static void main(String[] args) {
    Scanner sacn = new Scanner();
    System.in.read(sacn);
    Set<String> dict = new HashSet<String>();
    dict.add("hot");
    dict.add("cog");
    dict.add("dog");
    dict.add("tot");
    dict.add("hog");
    dict.add("hop");
    dict.add("pot");
    dict.add("dot");
    int[] A = {1, 2, 3, 4};
    int result = new temp().totalNQueens(4);
    System.out.println(result);
  }
}

