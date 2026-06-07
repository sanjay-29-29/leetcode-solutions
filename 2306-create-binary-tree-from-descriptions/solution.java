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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap(); 
        Set<Integer> childs = new HashSet();
        Set<Integer> parents = new HashSet();

        for(int[] node : descriptions) {
            TreeNode parent = map.getOrDefault(node[0], new TreeNode(node[0]));
            TreeNode child = map.getOrDefault(node[1], new TreeNode(node[1])); 

            if(node[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            childs.add(child.val);
            parents.add(parent.val);
            parents.add(child.val);

            map.put(node[0], parent);
            map.put(node[1], child);
        }

        // System.out.println(parents);
        // System.out.println(childs);

        for(int val : parents) {
            if(!childs.contains(val)) {
                return map.get(val);
            }
        }

        return null;
    }
}
