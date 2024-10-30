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

    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Long> map = new HashMap<>(); 
        
        queue.add(new Node(root, 1));
        
        while(!queue.isEmpty()){
            Node node = queue.remove();

            if(node.root == null){
                continue;
            }
            
            if(!map.containsKey(node.level)){
                map.put(node.level, (long)node.root.val);
            }else{
                map.put(node.level, map.get(node.level) + node.root.val);
            }

            queue.add(new Node(node.root.left, node.level + 1));
            queue.add(new Node(node.root.right, node.level + 1));
        }
        
        ArrayList<Long> listOfValues = new ArrayList<>(map.values());
        Collections.sort(listOfValues, Collections.reverseOrder());
        
        if(listOfValues.size() < k){
            return -1;
        }

        return listOfValues.get(k-1);
    }
}
