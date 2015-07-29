public class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    if (k > n) {
      return result;
    }

    DFShelper(n, k, 0, new ArrayList<Integer>(), result);
    return result;
  }

  private void DFShelper(int n, int k, int pos, List<Integer> taken, List<List<Integer>> result) {
    if (taken.size() == k) {
      result.add(new ArrayList<Integer>(taken));
      return;
    }

    for (int i = pos; i < n; i++) {
      taken.add(i + 1);
      DFShelper(n, k, i + 1, taken, result);
      taken.remove(taken.size() - 1);
    }
  }
}