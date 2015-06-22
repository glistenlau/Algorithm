import java.util.ArrayList;

/**
 * Created by YiLIU on 6/21/15.
 */
public class MergeSortedArrayII {
  public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    // write your code here
    int m = A.size() - 1;
    int n = B.size() - 1;
    while (m >= 0 && n >= 0) {
      if (A.get(m) > B.get(n)) {
        result.add(0, A.get(m--));
      } else {
        result.add(0, B.get(n--));
      }
    }
    while (m >= 0) {
      result.add(0, A.get(m--));
    }
    while (n >= 0) {
      result.add(0, B.get(n--));
    }
    return result;
  }
}
