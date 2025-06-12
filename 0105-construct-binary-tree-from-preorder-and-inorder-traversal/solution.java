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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Set<Integer> preorderSet = new LinkedHashSet<>();
        for(int i : preorder) {
            preorderSet.add(i);
        }
        return build(preorder[0], preorderSet, inorder, 0, inorder.length);
    }

    private TreeNode build(int root, Set<Integer> preorder, int[] inorder, int lower, int upper) {
        Set<Integer> leftTree = new HashSet<>();
        Set<Integer> rightTree = new HashSet<>();

        preorder.remove(root);

        boolean pivot = false;
        int foundIndex = -1;

        for (int i = lower; i < upper; i++) {
            if (inorder[i] == root) {
                foundIndex = i;
                pivot = true;
                continue;
            }
            // boolean status = visited.contains(inorder[i]);
            // if (pivot && status) {
            //     break;
            // }
            if (pivot) {
                rightTree.add(inorder[i]);
            } else {
                leftTree.add(inorder[i]);
            }
        }

        // System.out.println(root + " " + leftTree + " " + rightTree);
        // System.out.println(root + " " + lower + " " + upper);

        if (leftTree.size() == 0 && rightTree.size() == 0) {
            return new TreeNode(root, null, null);
        }

        TreeNode left = null, right = null;

        for (int i : preorder) {
            if (leftTree.contains(i)) {
                left = build(i, preorder, inorder, lower, foundIndex);
                break;
            }
        }

        for(int i : preorder) {
            if (rightTree.contains(i)) {
                right = build(i, preorder, inorder, foundIndex + 1, upper);
                break;
            }
        }

        return new TreeNode(root, left, right);
    }
}
