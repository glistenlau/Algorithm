import java.util.ArrayList;

/**
 * Serialize an N-ary Tree 将树存到文件里,要求可以还原。
 */
public class SerializeNArrayTree {
  private class NArrayTree{
    int val;
    ArrayList<NArrayTree> children;
    NArrayTree(int val) {
      this.val = val;
      children = new ArrayList<>();
    }
  }

  public String serialize(NArrayTree root) {
    StringBuilder ans = new StringBuilder();
    preOrder(root, ans);
    return ans.toString();
  }

  private void preOrder(NArrayTree root, StringBuilder ans) {
    if (root == null) {
      return;
    }

    ans.append(root.val);
    ans.append(',');

    for (NArrayTree child: root.children) {
      preOrder(child, ans);
    }

    ans.append('$');
    ans.append(',');
  }

  public NArrayTree deserialize(String data) {
    String[] nodes = data.split(",");
    return deserialize(new int[1], nodes);
  }

  private NArrayTree deserialize(int[] index, String[] nodes) {
    if (index[0] == nodes.length) {
      return null;
    }

    NArrayTree root = new NArrayTree(Integer.parseInt(nodes[index[0]++]));

    while (!nodes[index[0]].equals("$")) {
      root.children.add(deserialize(index, nodes));
    }

    index[0]++;
    return root;
  }

  public static void main(String[] args) {
    String s = "1,1,4,$,5,$,$,2,6,$,$,3,7,$,8,$,9,$,$,$";
    NArrayTree root = new SerializeNArrayTree().deserialize(s);
    System.out.println(new SerializeNArrayTree().serialize(root));
  }
}
