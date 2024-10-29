/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node{
        TreeNode root;
        int level;
        Node(TreeNode root, int level){
            this.root = root;
            this.level = level;
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, List<Node>> map = new HashMap<>();

        Node prev = null;
        Node node = null;        
        
        queue.add(new Node(root, 1));
        
        while(!queue.isEmpty()){
            node = queue.remove();
            if(node.root == null){
                continue;
            }
            if(map.containsKey(node.level)){
                List<Node> l = map.get(node.level);
                l.add(node);
            }else{
                List<Node> l = new ArrayList<>();
                l.add(node);
                map.put(node.level, l);
            }
            queue.add(new Node(node.root.left, node.level + 1));
            queue.add(new Node(node.root.right, node.level + 1));
        }
        for(int i : map.keySet()){
            List<Node> l = map.get(i);
            Node n = l.get(l.size()-1);
            list.add(n.root.val);    
        }
        return list;    
    }
}
