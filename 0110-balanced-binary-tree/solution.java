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
    Map<TreeNode, Integer> map = new HashMap<>();

    public int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        if(map.containsKey(root)) {
            return map.get(root);
        }

        int h = 1 + Math.max(height(root.left), height(root.right));
        map.put(root, h);
        return h;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int h1 = height(root.left);
        int h2 = height(root.right);

        if(Math.abs(h1 - h2) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}
