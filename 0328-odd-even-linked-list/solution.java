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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null, oddCurr = null, evenHead = null, evenCurr = null;
        int j = 0;

        for (ListNode i = head; i != null; i = i.next, j++) {
            if (j % 2 == 0) {
                if (oddHead == null) {
                    oddHead = i;
                    oddCurr = i;
                } else {
                    oddCurr.next = i;
                    oddCurr = i;
                }
            } else {
                if (evenHead == null) {
                    evenHead = i;
                    evenCurr = i;
                } else {
                    evenCurr.next = i;
                    evenCurr = i;
                }
            }
        }

        if (evenCurr != null) {
            evenCurr.next = null;
        }

        if (oddHead == null) {
            return evenHead;
        }

        oddCurr.next = evenHead;
        
        return oddHead;
    }
}
