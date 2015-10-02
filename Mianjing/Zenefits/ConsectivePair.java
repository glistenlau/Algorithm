/**
 * Created by YiLIU on 9/28/15.
 */
public class ConsectivePair {
  public static boolean concecutivePairs(int[] array) {
    if (array == null || array.length < 6) {
      return false;
    }
    int one = -1;
    int two = -1;
    for (int i = 0; i < array.length; i++) {
      int cur = array[i];
      int j = i + 1;
      for (; j < array.length && array[i] == array[j]; j++) ;
      if (one == -1) {
        if (j - i >= 2) {
          one = j - 1;
        }
      } else if (two == -1) {
        if (j - i == 2 && array[one] + 1 == cur) {
          two = j - 1;
        } else {
          if (j - i >= 2) {
            one = j - 1;
          } else {
            one = -1;
          }
        }
      } else {
        if (j - i == 2 && array[two] + 1 == cur) {
          return true;
        } else {
          if (j - i >= 2) {
            one = j - 1;
          } else {
            one = -1;
            two = -1;
          }
        }
      }

      i = j - 1;
    }
    return false;
  }


  public static void main(String[] args) {
    System.out.println(new ConsectivePair().concecutivePairs(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
  }
}
