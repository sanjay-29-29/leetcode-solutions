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
    class Node {
        TreeNode tree;
        int level;

        Node(TreeNode _tree, int _level) {
            tree = _tree;
            level = _level;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        queue.add(new Node(root, 0));
        int currLevel = 0;

        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (node.tree == null) {
                continue;
            }

            if (!set.contains(node.level)) {
                list.add(node.tree.val);
                set.add(node.level);
            }

            if(list.get(node.level) < node.tree.val){
                list.set(node.level, node.tree.val);
            }

            queue.add(new Node(node.tree.left, node.level + 1));
            queue.add(new Node(node.tree.right, node.level + 1));
        }

        return list;
    }
}
