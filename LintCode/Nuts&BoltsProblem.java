/**
 * Nuts & Bolts Problem
 * www.lintcode.com/en/problem/nuts-bolts-problem/
 *
 * Given a set of n nuts of different sizes and n bolts of different sizes. There is a one-one mapping
 * between nuts ans bolts. Comparison of a nut to another nut or a bolt to another bolt is not allowed.
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see which one
 * is bigger/smaller.
 */
/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
 */
public class Solution {
  /**
   * @param nuts: an array of integers
   * @param bolts: an array of integers
   * @param compare: a instance of Comparator
   * @return: nothing
   */
  public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
    if (nuts == null || nuts.length == 0) {
      return;
    }

    sortNutsAndBolts(nuts, bolts, 0, nuts.length - 1, compare);
  }

  private void sortNutsAndBolts(String[] nuts, String[] bolts, int left, int right, NBComparator compare) {
    if (left >= right) {
      return;
    }

    String pivotB = bolts[left + (right - left) / 2];
    String pivotN = null;
    int p = quickSort(nuts, left, right, pivotB, compare, "nuts");
    pivotN = nuts[p];
    quickSort(bolts, left, right, pivotN, compare, "bolts");
    sortNutsAndBolts(nuts, bolts, left, p, compare);
    sortNutsAndBolts(nuts, bolts, p + 1, right, compare);
  }

  private int quickSort(String[] strs, int left, int right, String pivot, NBComparator compare, String mode) {
    int l = left;
    int r = right;
    while (l <= r) {
      while (l <= r && getOrder(compare, pivot, strs[l], mode) == -1) {
        l++;
      }
      while (l <= r && getOrder(compare, pivot, strs[r], mode) == 1) {
        r--;
      }

      if (l <= r) {
        swap(strs, l++, r--);
      }
    }
    for (int i = left; i <= right; i++) {
      if (getOrder(compare, pivot, strs[i], mode) == 0) {
        return i;
      }
    }

    return -1;
  }

  private int getOrder(NBComparator compare, String pivot, String str, String mode) {
    if (mode == "nuts") {
      return -compare.cmp(str, pivot);
    } else {
      return compare.cmp(pivot, str);
    }
  }

  private void swap(String[] arr, int a , int b) {
    String temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }
};
