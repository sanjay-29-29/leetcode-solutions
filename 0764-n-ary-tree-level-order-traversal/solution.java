/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Temp {
        Node tree;
        int level;

        Temp(Node _tree, int _level) {
            tree = _tree;
            level = _level;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        Queue<Temp> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(new Temp(root, 0));
        int currLevel = 0;

        while (!queue.isEmpty()) {
            Temp node = queue.remove();

            if (node.tree == null) {
                continue;
            }

            if (!set.contains(node.level)) {
                List<Integer> l = new ArrayList<>();
                list.add(l);
                set.add(node.level);
            }
            
            List<Integer> l = list.get(node.level);
            l.add(node.tree.val);

            for(Node n : node.tree.children){
                queue.add(new Temp(n, node.level + 1));
            }
        }

        return list;
    }
}
