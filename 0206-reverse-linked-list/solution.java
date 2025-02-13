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
    ListNode ans = null;
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            ans = head;
            return head;
        }

        ListNode reverse = reverse(head.next);
        reverse.next = head;
        return head;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        reverse(head); 
        head.next = null;
        return ans;
    }
}
