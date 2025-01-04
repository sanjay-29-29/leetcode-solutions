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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> res = new ArrayList<>(); 
    calcSum(root, targetSum, new ArrayList<>(), res);
    return res;
    }

    private void calcSum(TreeNode root, int targetSum, List<Integer> list, List<List<Integer>> res){
        if(root == null) return;

        if(root.left == null && root.right == null && targetSum - root.val == 0){
            list.add(root.val);
            res.add(list);
            return;
        }
        
        list.add(root.val);
        //System.out.println(list);

        calcSum(root.left, 
            targetSum - root.val,
            new ArrayList<>(list),
            res
        );
        calcSum(root.right, 
            targetSum - root.val,
            new ArrayList<>(list),
            res
        );
    }
}
