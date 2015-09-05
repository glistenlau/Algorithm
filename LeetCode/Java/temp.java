import java.util.*;

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */
public class temp {
  private class NBComparator{
    public int compare(String a, String b) {
      return
    }
  }
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
    for (int i = left; i <= right; i++) {
      if (compare.cmp(nuts[i], pivotB) == 0) {
        pivotN = nuts[i];
        break;
      }
    }
    int p = quickSort(nuts, left, right, pivotB, compare, "nuts");

    pivotN = nuts[p];
    quickSort(bolts, left, right, pivotN, compare, "bolts");

    sortNutsAndBolts(nuts, bolts, left, p, compare);
    sortNutsAndBolts(nuts, bolts, p + 1, right, compare);
  }

  private int quickSort(String[] strs, int left, int right, String pivot, NBComparator compare, String mode) {
    int l = 0;
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

    return l;
  }

  private int getOrder(NBComparator compare, String pivot, String str, String mode) {
    if (mode == "nuts") {
      return compare.cmp(str, pivot);
    } else {
      return compare.cmp(pivot, str);
    }
  }

  private void swap(String[] arr, int a , int b) {
    String temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }


  public static void main(String[] args) {
    String[] temp = {"oath", "pea", "eat", "rain"};
    char[][] board = {
        {'o', 'a', 'a', 'n'},
        {'e', 't', 'a', 'e'},
        {'i', 'h', 'k', 'r'},
        {'o', 'f', 'l', 'v'}
    };

    Set<String> dict = new HashSet<String>();

    for (int i = 0; i < temp.length; i++) {
      dict.add(temp[i]);
    }

    String[] strA = {"1 + 1", " 2-1 + 2", "(1 + (4+5+2)-3) + (6+8)"};
    int i = 0;


    char[][] sodoku = {{'X', 'X', 'X', 'X'},
        {'X', 'O', 'O', 'X'},
        {'X', 'X', 'O', 'X'},
        {'X', 'O', 'X', 'X'}};
    int[] A = {3, 2, 1, 3, 3, 3, 5, 6, 3, 7};
    int[] BB = {5, 6, 7, 3, 2, 1, 0};
    int[][] matrix1 = {{4,67,187},{3,80,65},{49,77,117},{67,74,9},{6,42,92},{48,67,69},{10,13,58},{47,99,152},{66,99,53},{66,71,34},{27,63,2},{35,81,116},{47,49,10},{68,97,175},{20,33,53},{24,94,20},{74,77,155},{39,98,144},{52,89,84},{13,65,222},{24,41,75},{16,24,142},{40,95,4},{6,56,188},{1,38,219},{19,79,149},{50,61,174},{4,25,14},{4,46,225},{12,32,215},{57,76,47},{11,30,179},{88,99,99},{2,19,228},{16,57,114},{31,69,58},{12,61,198},{70,88,131},{7,37,42},{5,48,211},{2,64,106},{49,73,204},{76,88,26},{58,61,215},{39,51,125},{13,38,48},{74,99,145},{4,12,8},{12,33,161},{61,95,190},{16,19,196},{3,84,8},{5,36,118},{82,87,40},{8,44,212},{15,70,222},{16,25,176},{9,100,74},{38,78,99},{23,77,43},{45,89,229},{7,84,163},{48,72,1},{31,88,123},{35,62,190},{21,29,41},{37,97,81},{7,49,78},{83,84,132},{33,61,27},{18,45,1},{52,64,4},{58,98,57},{14,22,1},{9,85,200},{50,76,147},{54,70,201},{5,55,97},{9,42,125},{31,88,146}};

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(6);
    TreeLinkNode tln = new TreeLinkNode(1);
    tln.left = new TreeLinkNode(2);
    tln.right = new TreeLinkNode(3);
    tln.left.left = new TreeLinkNode(4);
    tln.left.right = new TreeLinkNode(5);
    tln.right.right = new TreeLinkNode(7);


    List<Interval> test = new ArrayList<>();
    test.add(new Interval(1, 2));
    test.add(new Interval(3, 5));
    test.add(new Interval(6, 7));
    test.add(new Interval(8, 10));
    test.add(new Interval(12, 16));
    Queue<Set<String>> myQueue = new LinkedList<>();

    ArrayList<Integer> B = new ArrayList<Integer>();
    for (int n: A) {
      B.add(n);
    }
//    Point[] pts= {new Point(0, 0), new Point(0, 1), new Point(2, 2), new Point(2, 1)};
//
//    ListNode head = new ListNode(4);
//    head.next = new ListNode(3);
//    head.next.next = new ListNode(1);
//    head.next.next.next = new ListNode(5);
//    head.next.next.next.next = new ListNode(2);
    boolean check = dict.contains("hot");
    String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
    int[] pre = {1, 2, 5, 6, 3, 7, 8};
    int[] in = {5, 2, 6, 1, 7, 3, 8};
    int[] post = {5, 6, 2, 7, 8, 3, 1};
    ArrayList<Interval> quries = new ArrayList<>();
    quries.add(new Interval(1, 2));
    quries.add(new Interval(0, 4));
    quries.add(new Interval(2, 4));
    int[] col = new int[1000];

    List<Integer> a1 = new ArrayList<>(B);
    List<Integer> a2 = new ArrayList<>(B);
    new temp().partition(A, 0, A.length - 1);
    System.out.println(A);
  }
}

