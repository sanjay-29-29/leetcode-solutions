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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean reverse = isReverseEqual(new ArrayList<>(queue));
            if(reverse == false){
                return false;
            }
            while(size > 0){
                TreeNode curr = queue.poll();
                if(curr != null){
                    queue.offer(curr.left);
                    queue.offer(curr.right);
                }
                size--;
            }
        }

        return true;
    }

    private boolean isReverseEqual(List<TreeNode> list){
        List<TreeNode> copy = new ArrayList<>(list);
        Collections.reverse(copy);
        // System.out.println(list);
        // System.out.println(copy);
        for(int i = 0; i < copy.size(); i++){
            TreeNode left = list.get(i);
            TreeNode right = copy.get(i);
            if(left == null && right == null){
                continue;
            }
            if(left == null && right != null || right == null && left != null){
                return false;
            }
            if(left.val != right.val){
                return false;
            }
        }
        return true;
    }
}
