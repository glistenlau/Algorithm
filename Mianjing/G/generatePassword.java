import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 用尽量短的string生成4位数密码的所有组合.
 *
 * The solution is same idea with the shortest sequence problem, there are 10000 possible
 * password, so we can convert to a graph with 1000 vertices, like 000, 001, 002, 003, ..., 999,
 * every vertex has 10 exit from 0 to 9, and has 10 entry. So we can generate 10 times sequence
 * get the answer.
 */
public class GeneratePassword {
  private class GraphNode{
    String val;
    ArrayList<GraphNode> neighbors;
    GraphNode(String val) {
      this.val = val;
      this.neighbors = new ArrayList<>();
    }
  }

  private GraphNode initiateGraph() {
    HashMap<String, GraphNode> nodes = new HashMap<>();

    for (int i = 0; i < 1000; i++) {
      String val = String.valueOf(i);
      if (val.length() == 1) {
        val = "00" + val;
      } else if (val.length() == 2) {
        val = "0" + val;
      }

      nodes.put(val, new GraphNode(val));
    }

    for (String val: nodes.keySet()) {
      GraphNode node = nodes.get(val);
      String base = val.substring(1);
      for (int j = 0; j < 10; j++) {
        node.neighbors.add(nodes.get(base + j));
      }
    }

    return nodes.get("000");
  }

  public String generatePassword() {
    GraphNode node = initiateGraph();
    StringBuilder ans = new StringBuilder();

    ans.append("000");
    node = search(node, ans, 1000);


    return ans.toString();
  }

  private GraphNode search(GraphNode node, StringBuilder ans, int n) {

    ans.append(node.val.charAt(2));
    if (n == 0) {
      return node;
    }

    for (int i = 0; i < node.neighbors.size(); i++) {
      GraphNode neighbor = node.neighbors.get(i);
      node.neighbors.remove(neighbor);
      GraphNode rst = search(neighbor, ans, n - 1);
      if (rst != null) {
        return rst;
      }
      node.neighbors.add(i, neighbor);
    }

    ans.deleteCharAt(ans.length() - 1);

    return null;
  }

  public static void main(String[] args) {
    System.out.println(new GeneratePassword().generatePassword());
  }
}
