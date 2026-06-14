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
class Solution {
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack();
        int length = 0;

        for(ListNode i = head; i != null; i = i.next) {
            stack.add(i);
            length += 1;
        }

        int i = 0, res = 0;

        ListNode current = head;

        while(i < length / 2) {
            res = Math.max(res, stack.pop().val + current.val);
            current = current.next;
            i++;
        }

        return res;
    }
}
