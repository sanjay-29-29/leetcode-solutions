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
        Stack<ListNode> stack = new Stack<>();
        int size = 0;
        ListNode curr = head;

        for(int i = 0; curr != null; i++) {
            size++;
            stack.push(curr); 
            curr = curr.next;
        }


        int max = 0;
        int i = 0;
        curr = head;

        while(i < size / 2) {
            int sum = curr.val + stack.pop().val;
            max = Math.max(max, sum);
            curr = curr.next;
            i++;
        }

        return max;
    }
}
