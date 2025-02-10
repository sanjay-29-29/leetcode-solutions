/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node prev = null;

        while(!queue.isEmpty()){
            int size = queue.size();
            prev = null;
            while(size != 0){
                Node curr = queue.poll();
                if(curr == null){
                    size--;
                    continue;
                }
                if(prev != null){
                    prev.next = curr;
                }
                queue.add(curr.left);
                queue.add(curr.right);
                prev = curr;
                size--;
            }
        }

        return root;
    }
}
