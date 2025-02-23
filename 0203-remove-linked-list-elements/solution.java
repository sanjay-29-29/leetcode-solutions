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
    public ListNode removeElements(ListNode head, int val) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            if(curr.val == val){
                if(prev == null){
                    head = head.next;
                    curr = curr.next;
                    continue;
                }else{
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }else{
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }
}
