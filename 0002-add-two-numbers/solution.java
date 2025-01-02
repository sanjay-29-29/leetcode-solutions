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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode temp = null;
        ListNode head = null;
        
        while(l1 != null || l2 != null){
            int currSum = carry;
            if(l1 != null){
                currSum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                currSum += l2.val;
                l2 = l2.next;
            }
            if(currSum >= 10){
                currSum %= 10;
                carry = 1;
            }else{
                carry = 0;
            }
            if(head == null){
                temp = new ListNode(currSum);
                head = temp;
            }else{
                temp.next = new ListNode(currSum);
                temp = temp.next;
            }
        }

        if(carry == 1){
            temp.next = new ListNode(1);
        }

        return head;
    }
}
