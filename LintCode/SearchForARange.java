import java.util.ArrayList;

/**
 * Created by YiLIU on 6/19/15.
 */
public class SearchForARange {
  public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
    int left = 0;
    int right = A.size() - 1;
    ArrayList<Integer> result = new ArrayList<>();
    if (A.size() == 0) {
      result.add(-1);
      result.add(-1);
      return result;
    }
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A.get(mid) == target) {
        right = mid;
      } else if (A.get(mid) < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (A.get(left) == target) {
      result.add(left);
    } else if (A.get(right) == target) {
      result.add(left);
    } else {
      result.add(-1);
      result.add(-1);
      return result;
    }
    left = 0;
    right = A.size() - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (A.get(mid) == target) {
        left = mid;
      } else if (A.get(mid) < target) {
        left = mid;
      } else {
        right = mid;
      }
    }
    if (A.get(right) == target) {
      result.add(right);
    } else if (A.get(left) == target) {
      result.add(left);
    }

    return result;
  }

  public static void main(String[] args) {
    ArrayList<Integer> A = new ArrayList<>();
    A.add(5);
//    A.add(7);
//    A.add(7);
//    A.add(8);
//    A.add(8);
//    A.add(10);
    System.out.println(new SearchForARange().searchRange(A, 5));
  }
}
