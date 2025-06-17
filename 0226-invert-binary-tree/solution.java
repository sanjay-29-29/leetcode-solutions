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
    public TreeNode invertTree(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        List<List<TreeNode>> list = new ArrayList<>();

        q1.add(root);

        while(!q1.isEmpty()) {
            int size = q1.size();
            List<TreeNode> elements = new ArrayList<>();

            while(size > 0) {
                TreeNode n = q1.poll();
                elements.add(n);
                if(n != null) {
                    q1.offer(n.left);
                    q1.offer(n.right);
                }
                size--;
            }

            list.add(elements);
        }

        for(List<TreeNode> l : list) {
            Collections.reverse(l);
        }

        TreeNode newRoot = null, curr = null;
        Queue<TreeNode> q2 = new LinkedList<>();
        
        for(List<TreeNode> l : list) {
            // System.out.println(l);
            for(int i = 0; i < l.size(); i += 2) {
                if(newRoot == null) {
                    newRoot = l.get(0);
                    q2.offer(newRoot);
                } else {
                    TreeNode next = q2.poll();
                    if(next == null) {
                        i -= 2;
                        continue;
                    }
                    next.left = l.get(i);
                    next.right = l.get(i + 1);
                    q2.offer(next.left); q2.offer(next.right);
                }
            }
        }

        return newRoot;
    }
}
