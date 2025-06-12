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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = inorder.length - 1; i >= 0; i--) {
            set.add(postorder[i]);
        }
        return build(postorder[postorder.length - 1], set, inorder, 0, inorder.length);
    }

    private TreeNode build(int root, Set<Integer> preorder, int[] inorder, int lower, int upper) {
        Set<Integer> leftTree = new HashSet<>();
        Set<Integer> rightTree = new HashSet<>();

        preorder.remove(root);

        int pivot = -1;

        for (int i = lower; i < upper; i++) {
            if (inorder[i] == root) {
                pivot = i;
            } else if (pivot != -1) {
                rightTree.add(inorder[i]);
            } else {
                leftTree.add(inorder[i]);
            }
        }

        if (leftTree.size() == 0 && rightTree.size() == 0) {
            return new TreeNode(root, null, null);
        }

        TreeNode left = null, right = null;

        for (int i : preorder) {
            if (leftTree.contains(i)) {
                left = build(i, preorder, inorder, lower, pivot);
                break;
            }
        }

        for (int i : preorder) {
            if (rightTree.contains(i)) {
                right = build(i, preorder, inorder, pivot + 1, upper);
                break;
            }
        }

        return new TreeNode(root, left, right);
    }
}
