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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null){
            return new ArrayList<>();
        }

        queue.add(root);

        while(!queue.isEmpty()){
            int queueSize = queue.size();
            List<Integer> list = new ArrayList<>();

            while(queueSize != 0){
                TreeNode ele = queue.poll();
                list.add(ele.val);
                if(ele.left != null) queue.add(ele.left);
                if(ele.right != null) queue.add(ele.right);
                queueSize--;
            }

            res.add(list);
        }

        return res;
        
    }
}
