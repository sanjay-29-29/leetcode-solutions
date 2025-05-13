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
    private int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(
            depth(root.left),
            depth(root.right)
        );
    }

    public boolean isCompleteTree(TreeNode root) {
        // List<List<TreeNode>> list = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = false;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            // List<TreeNode> l = new LinkedList<>();

            while (size > 0) {
                TreeNode t = q.poll();
                // l.add(t);
                
                if (t == null) {
                    flag = true;
                    size--;
                    continue;
                }

                if(flag && t != null) {
                    return false;
                }

                q.add(t.left);
                q.add(t.right);
                size--;
            }

            // list.add(l);
        }

        // List<TreeNode> last = list.get(depth(root) - 1);
        // boolean flag = false;

        // for (TreeNode n : last) {
        //     if (n == null) {
        //         flag = true;
        //         continue;
        //     }
        //     if (flag && n != null) {
        //         return false;
        //     }
        //     System.out.println(n.val);
        // }

        return true;
    }
}
