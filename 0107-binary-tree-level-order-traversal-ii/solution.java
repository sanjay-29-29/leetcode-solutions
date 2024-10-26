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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        class Node{
            TreeNode node;
            int level;
            Node(TreeNode node, int level){
                this.node = node;
                this.level = level;
            }
        }
        
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        Stack<Node> stack = new Stack<>();
        HashSet<Integer> set = new HashSet<>();

        stack.add(new Node(root, 0));

        while(!stack.isEmpty()){
            Node node = stack.pop();
            if(node.node == null){
                continue;
            }
            if(set.contains(node.level)){
                List<Integer> list = returnList.get(node.level);
                list.add(node.node.val);
            }else{
                set.add(node.level);
                List<Integer> list = new ArrayList<Integer>();
                list.add(node.node.val);
                returnList.add(list);
            }
            stack.push(new Node(node.node.right, node.level + 1));
            stack.push(new Node(node.node.left, node.level + 1));
        }
        Collections.reverse(returnList);
        return returnList;
    }
}
