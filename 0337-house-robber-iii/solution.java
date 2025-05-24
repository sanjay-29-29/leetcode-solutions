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
    Map<String, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        return Math.max(
            recurse(root, false),
            recurse(root, true)
        );
    }

    private int recurse(TreeNode root, boolean prevRobbed) {
        if(root == null) {
            return 0;
        }
        String key = root + " " + prevRobbed;
        if(map.containsKey(key)) {
            return map.get(key);
        }

        if(prevRobbed) {
            int val = recurse(root.left, false) + recurse(root.right, false);
            map.put(key, val);
            return val;
        }

        int val = Math.max(
            root.val + recurse(root.left, true) + recurse(root.right, true),
            recurse(root.left, false) + recurse(root.right, false)
        );  
        map.put(key, val);
        return val;
    }
}
