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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if(head == null) return head;

        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }

        ListNode prev = null, curr = head; 


        while(curr != null) {
            if(set.contains(curr.val)) {
                if(curr == head) {
                    head = head.next;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return head;
    }
}
