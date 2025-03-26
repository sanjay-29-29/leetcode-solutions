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
    public TreeNode deleteNode(TreeNode root, int key) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list, key);
        return toBST(0, list.size() - 1, list);
    }

    public TreeNode toBST(int left, int right, List<Integer> list){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        return new TreeNode(
            list.get(mid),
            toBST(left, mid - 1, list),
            toBST(mid + 1, right, list)
        );
    }

    private void traverse(TreeNode root, List<Integer> list, int val){
        if(root == null){
            return;
        }
        traverse(root.left, list, val);
        if(root.val != val){
            list.add(root.val);
        }
        traverse(root.right, list, val);
    }
}
