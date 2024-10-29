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

    public int maxLevelSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root, 1));
        int level = 0;
        int levelSum = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Node node = queue.remove();
            if(node.root == null){
                continue;
            }
            if(map.containsKey(node.level)){
                map.put(node.level, map.get(node.level) + node.root.val);
            }else{
                map.put(node.level, node.root.val);
            }
            queue.add(new Node(node.root.left, node.level+1));
            queue.add(new Node(node.root.right, node.level+1));
        }   
 
         for(int i : map.keySet()){
            int val = map.get(i);
            System.out.println(val);
            if(levelSum < val){
                levelSum = val;
                level = i;
            }
        }
        return level;
    }
}
