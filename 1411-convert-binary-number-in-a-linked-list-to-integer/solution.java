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
        int size = getSize(head) - 1;
        int res = 0;

        while(head != null) {
            if(head.val != 0)
                res += Math.pow(2, size * head.val);
            head = head.next;
            size--;
        }

        return res;
    }

    private int getSize(ListNode head) {
        int temp = 0;
        while(head != null) {
            head = head.next;
            temp++;
        }
        return temp;
    }
}
