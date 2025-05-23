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
class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode root){
        if(root == null){
            return;
        }
        traverse(root.right);
        stack.add(root);
        traverse(root.left);
    }
    
    public int next() {
        if(!stack.isEmpty()){
            return stack.pop().val;
        }
        return -1;
    }
    
    public boolean hasNext() {
       return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
