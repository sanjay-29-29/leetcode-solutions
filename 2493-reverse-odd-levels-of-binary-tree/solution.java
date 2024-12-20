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
    class LevelNode {
        TreeNode node;
        int level;

        LevelNode(TreeNode _node, int _level) {
            node = _node;
            level = _level;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> revQ = new LinkedList<>();
        Queue<LevelNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        queue.add(new LevelNode(root, 0));

        while (!queue.isEmpty()) {
            LevelNode curr = queue.poll();

            if (curr.node == null) {
                continue;
            }

            if (curr.level % 2 != 0) {
                revQ.add(curr.node);
                stack.add(curr.node.val);
            }
            else{
                while (!stack.isEmpty()) {
                    TreeNode node = revQ.poll();
                    node.val = stack.pop();
                }
            }

            queue.add(new LevelNode(curr.node.right, curr.level + 1));
            queue.add(new LevelNode(curr.node.left, curr.level + 1));
        }

        while (!stack.isEmpty()) {
            TreeNode node = revQ.poll();
            node.val = stack.pop();
        }

        return root;
    }
}
