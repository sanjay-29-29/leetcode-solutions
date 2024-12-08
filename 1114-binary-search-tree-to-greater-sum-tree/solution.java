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
    int index;
    int currSum;

    public TreeNode bstToGst(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list); 
        for(int ele : list){
            currSum += ele;
        }
        // System.out.println(currSum);
        toGst(root, list);
        return root;
    }

    private void toGst(TreeNode root, List<Integer> list){
       if(root == null) {
        return;
       }
       toGst(root.left, list);
    //    System.out.println(root.val + " " + currSum);
       int temp = root.val;
       root.val = currSum;
       currSum = currSum - temp;
       toGst(root.right, list);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
