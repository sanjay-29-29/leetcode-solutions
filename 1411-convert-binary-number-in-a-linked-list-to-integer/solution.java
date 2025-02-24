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
    public int getDecimalValue(ListNode head) {
        String res = "";
        ListNode temp = head;
        int count = 0;

        while(temp != null){
            count = count << 1;
            count = count | temp.val;
            temp = temp.next;
        }


        return count;
    }
}
