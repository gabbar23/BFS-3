Time Complexity (TC): O(V + E), where V is the number of nodes and E is the number of edges in the graph. The DFS traverses each node and edge once, and we perform constant-time work for each node and its neighbors during the traversal.

Space Complexity (SC): O(V), where V is the number of nodes. The space is required for the recursive call stack and the HashMap that stores the mapping of original nodes to their deep copies. The HashMap stores one entry per node in the graph.
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private void dfs(Node node, HashMap<Node, Node> map) {
        // if already visisted // node already created
        if (map.containsKey(node))
            return;

        Node deepCopy = new Node(node.val);
        map.put(node,deepCopy);
        for (Node neigh : node.neighbors) {
            dfs(neigh, map);
            map.get(node).neighbors.add(map.get(neigh));

        }

    }

    public Node cloneGraph(Node node) {
        if(node==null)return null;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);

    }
}
