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
    public ListNode insertGreatestCommonDivisors(ListNode head) { 
        ListNode prev = null, temp = head;

        for(int i = 0; temp.next != null; i++) {
            ListNode newNode = new ListNode(gcd(temp.val, temp.next.val), temp.next);
            prev = temp.next;
            temp.next = newNode;
            temp = prev;
        }

        return head;
    }

    private int gcd(int a, int b) {
          if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
