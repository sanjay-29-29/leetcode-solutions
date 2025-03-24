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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right){
        if(left > right){
            return null;
        }
        int index = -1;
        int n = Integer.MIN_VALUE;

        for(int i = left; i <= right; i++){
            if(nums[i] > n){
                n = nums[i];
                index = i;
            }
        }

        return new TreeNode(
            n,
            buildTree(
                nums,
                left,
                index - 1
            ),
            buildTree(
                nums,
                index + 1,
                right
            )
        );
    }
}
