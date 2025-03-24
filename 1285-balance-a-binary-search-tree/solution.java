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
    public TreeNode balanceBST(TreeNode root) {
       List<Integer> list = new ArrayList<>();
       flattenBST(root, list);
       return toBST(0, list.size() - 1, list);
    }

    public TreeNode toBST(int left, int right, List<Integer> list){
        int mid = (left + right) / 2;
        if(left > right){
            return null;
        }
        TreeNode head = new TreeNode(list.get(mid), toBST(left, mid - 1, list), toBST(mid + 1, right, list));
        return head;
    }

    public void flattenBST(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        flattenBST(root.left, list);
        list.add(root.val);
        flattenBST(root.right, list);
    }
}
