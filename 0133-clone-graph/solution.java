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
        if (node == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if(map.containsKey(curr)){
                continue;
            }

            Node copy = new Node(curr.val);

            // System.out.println(curr.val);
            map.put(curr, copy);

            for (Node val : curr.neighbors) {
                queue.offer(val);
            }
        }

        
        Set<Node> set = new HashSet<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            // System.out.println(curr.val);
            if(set.contains(curr)){
                continue;
            }
            set.add(curr);
            Node copy = map.get(curr);

            for (Node val : curr.neighbors) {
                copy.neighbors.add(map.get(val));
                queue.offer(val);
            }
        }

        return map.get(node);
    }
}
