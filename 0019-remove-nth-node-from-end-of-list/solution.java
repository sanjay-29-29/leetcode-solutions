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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;

        ListNode temp = head;
        ListNode prev = head;
        ListNode test = head;

        while(temp != null){
            count++;
            if(count > n){
                prev = test;
                test = test.next;
            }
            temp = temp.next;
        }

        prev.next = test.next;

        if(head == test){
            return head.next;
        }

        if(prev == test){
            return null;
        }

        // prev.next = temp;
        return head;
    }
}
