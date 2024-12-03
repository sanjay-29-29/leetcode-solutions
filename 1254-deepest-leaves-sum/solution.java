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
    int sum;
    int depth;

    public int deepestLeavesSum(TreeNode root) {
        depth = calcMaxDepth(root);
        // System.out.println(depth);       
        calcMaxSum(root, 0);
        return sum; 
    }

    private void calcMaxSum(TreeNode root, int depth){
        if(root == null){
            return;
        }
        // System.out.println(depth);
        if(depth == this.depth - 1){
            sum += root.val;
            return;         
        }
        if(root.left == null && root.right != null){
            calcMaxSum(root.right, depth + 1);
            return;
        }
        if(root.left != null && root.right == null){
            calcMaxSum(root.left, depth + 1);
            return;
        }

        calcMaxSum(root.left, depth + 1);
        calcMaxSum(root.right, depth + 1);
    }

    private int calcMaxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right != null){
            return 1 + calcMaxDepth(root.right);
        }
        if(root.left != null && root.right == null){
            return 1 + calcMaxDepth(root.left);
        }
        return 1 + Math.max(calcMaxDepth(root.left), calcMaxDepth(root.right));
    }
}
