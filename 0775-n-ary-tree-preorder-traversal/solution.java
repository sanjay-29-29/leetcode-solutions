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
    public List<Integer> preorder(Node root) {
        Stack<Node> queue = new Stack<>();
        List<Integer> list = new ArrayList<>();

        queue.add(root);
        
        while(!queue.isEmpty()){
            Node node = queue.pop();
            
            if(node == null){
                continue;
            }

            list.add(node.val);
            Collections.reverse(node.children);
            for(Node n : node.children){
                queue.add(n);
            }
        }

        return list;
    }
}
