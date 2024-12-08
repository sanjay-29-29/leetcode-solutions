/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode ret = head;
        boolean flag = false;

        int sum = 0;

        while (slow != null && fast != null) {
            if(fast.val != 0){
                sum += fast.val;
                fast = fast.next;
            }
            else{ 
                //System.out.println(sum);
                slow.val = sum;
                slow = slow.next;
                fast = fast.next;
                sum = 0;
            }
        }

        slow.next = null;
        
        fast = ret.next;

        while(fast.next.next != null){;
            fast = fast.next;
        }
        fast.next = null;

        return ret.next;
    }
}
