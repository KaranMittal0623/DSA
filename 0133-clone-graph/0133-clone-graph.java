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
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // Clone the given node
        // Clone its neighbor and recursively its neighbour, but if node reappear we need to access the previous cloned node so store them in the map 
        Map<Node,Node> mp = new HashMap<>();
        Node cloneNode = new Node(node.val);
        mp.put(node,cloneNode);
        DFS(node,cloneNode,mp);
        return cloneNode;
    }

    public void DFS(Node node,Node cloneNode,Map<Node,Node> mp){
        for(Node n : node.neighbors){
            if(!mp.containsKey(n)){
                Node newNode = new Node(n.val);
                mp.put(n,newNode);
                cloneNode.neighbors.add(newNode);
                DFS(n,newNode,mp);

            }
            else{
                cloneNode.neighbors.add(mp.get(n));
            }
        }
    }
}