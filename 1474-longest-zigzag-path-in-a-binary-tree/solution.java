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
    int max;
    HashMap<String, Integer> map;

    public int longestZigZag(TreeNode root) {
        map = new HashMap<>();
        caller(root);
        return max;
    }

    private void caller(TreeNode root){
        if(root == null){
            return;
        }
        int val = Math.max(dfs(root,true),dfs(root,false));
        max = Math.max(max, val);
        caller(root.left);
        caller(root.right);
    }

    private int dfs(TreeNode root, boolean left){
        int hash = System.identityHashCode(root);
        String id = hash + " " + left;
        if(map.containsKey(id)){
            return map.get(id);
        }
        if(root == null){
            return 0;
        }
        if(left == true && root.left != null){
            int val =  1 + dfs(root.left, false);
            map.put(id, val);
            return val;
        }
        if(left == false && root.right != null){
            int val =  1 + dfs(root.right, true);
            map.put(id, val);
            return val;
        }
        return 0;
    }
}
