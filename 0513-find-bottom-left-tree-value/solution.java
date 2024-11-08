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
        TreeNode tree;
        int level;
        Node(TreeNode _tree, int _level){
            tree = _tree;
            level = _level;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 0));
        int currLevel = 0;
        int returnVal = root.val;

        while(!queue.isEmpty()){
            Node node = queue.remove();
            
            if(node.tree == null){
                continue;
            }
            
            if(currLevel != node.level){
                currLevel = node.level;
                returnVal = node.tree.val;
            }

            queue.add(new Node(node.tree.left, node.level + 1));
            queue.add(new Node(node.tree.right, node.level + 1));
        }
        return returnVal;
    }
}
