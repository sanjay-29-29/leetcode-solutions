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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currDepth = 2;

        while (!q.isEmpty()) {
            int size = q.size();
            if (depth == currDepth) {
                while (!q.isEmpty()) {
                    TreeNode curr = q.poll();
                    if (curr != null) {
                        curr.left = new TreeNode(val, curr.left, null);
                        curr.right = new TreeNode(val, null, curr.right);
                    }
                }
                break;
            }
            while (size > 0) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    size--;
                    continue;
                }
                q.offer(curr.left);
                q.offer(curr.right);
                size--;
            }
            currDepth++;
        }

        return root;
    }
}
