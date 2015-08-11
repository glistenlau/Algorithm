import java.util.ArrayList;
import java.util.List;

/**
 * Created by YiLIU on 8/10/15.
 */
public class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
