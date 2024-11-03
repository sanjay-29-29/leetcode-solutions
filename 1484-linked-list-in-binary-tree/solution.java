/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    ListNode head;
    boolean res;

    public boolean isSubPath(ListNode head, TreeNode root) {
        this.head = head;
        traverse(head, root);
        return res;
    }

    private void traverse(ListNode head, TreeNode root){
        if(root == null){
            return;
        }
        traverse(head, root.left);
        recursion(head, root);
        traverse(head, root.right);
    }

    private void recursion(ListNode head, TreeNode root){
        if(head == null){
            res = res || true;
            return;
        }
        if(root == null){
            res = res || false;
            return;
        }
        if(root.val == head.val){
            recursion(head.next, root.left);
            recursion(head.next, root.right);
            return;
        }
        res = res || false;
    }
}
