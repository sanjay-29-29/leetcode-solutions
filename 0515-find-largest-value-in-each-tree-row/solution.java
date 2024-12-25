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
        TreeNode node;
        int level;

        Node(TreeNode _node, int _level){
            node = _node;
            level = _level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();     
        List<Integer> list = new ArrayList<>(); 
        queue.add(new Node(root, 0));

        int level = -1;
        int maxVal = 0;

        if(root == null){
            return new ArrayList<>();
        }

        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.node == null){
                continue;
            }

            if(curr.level != level){
                if(level != -1){
                    list.add(maxVal);
                }
                level = curr.level;
                maxVal = curr.node.val; 
            }

            maxVal = Math.max(curr.node.val, maxVal);

            queue.add(new Node(curr.node.left, curr.level + 1));
            queue.add(new Node(curr.node.right, curr.level + 1));
        }

        list.add(maxVal);

        return list;
    }
}
