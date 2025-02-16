/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        return divideAndConquer(nums, 0, nums.length - 1);
    }

    private TreeNode divideAndConquer(int[] nums, int left, int right) { 
        int mid = (left + right) / 2;
        if(mid > right || mid < left){
            return null;
        }
        //System.out.println(mid + " " + left + " " + right);

        TreeNode node = new TreeNode(nums[mid]);

        node.left = divideAndConquer(nums, left, mid - 1);
        node.right = divideAndConquer(nums, mid + 1, right);

        return node;
    }
}
