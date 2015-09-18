import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * given number N which represents total number of leaves in tree.  you need to generate all possible tree,
 * such that each node in tree has zero child or two children. The return type should be a list of such kind
 * of trees. Only tree structure matters, tree node doesn't have any value initially.
 * My solution: N = 1 and N = 2 are base cases.
 * For example, N = 3.
 *      1                 1
 *    /    \            /   \
 *   1     1           1     1
 *  / \                    /  \
 * 1  1                   1   1
 * For N = 4, all possible trees can be generated from f(3) by attaching each leaf node with two children,
 * recursively follow this pattern to return target N. (Note: f(3) indicates a list of trees with 3 nodes in
 * structure described above).
 */
public class GetNLeafTrees {
 public List<TreeNode> getNLeafTrees(int n) {
  if (n == 0) {
   return new ArrayList<>();
  }

  List<List<TreeNode>> trees = new ArrayList<>();
  trees.add(new ArrayList<>(Arrays.asList(new TreeNode(1))));

  for (int i = 1; i < n; i++) {
   trees.add(new ArrayList<>());
   for (int j = 0; j < i; j++) {
    for (TreeNode left: trees.get(j)) {
     for (TreeNode right: trees.get(i - j - 1)) {
      TreeNode root = new TreeNode(1);
      root.left = left;
      root.right = right;
      trees.get(i).add(root);
     }
    }
   }
  }

  return trees.get(n - 1);
 }

 public static void main(String[] args) {
  List<TreeNode> rst = new GetNLeafTrees().getNLeafTrees(4);
  System.out.println(rst.size());
 }
}
