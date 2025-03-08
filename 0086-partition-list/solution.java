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
    public ListNode partition(ListNode head, int x) {
        Queue<ListNode> maxStack = new LinkedList<>();
        Queue<ListNode> minStack = new LinkedList<>();

        ListNode temp = head;

        while(temp != null){
            if(temp.val >= x){
                maxStack.add(temp);
            }else{
                minStack.add(temp);  
            }
            temp = temp.next;
        }

        ListNode head1 = null;
        ListNode curr1 = null;

        while(!minStack.isEmpty()) {
            ListNode curr = minStack.poll();
            curr.next = null;
            if(head1 == null){
                head1 = curr;
                curr1 = curr;
            }else{
                curr1.next = curr;
                curr1 = curr;
            }
        }

        ListNode head2 = null;
        ListNode curr2 = null;

        while(!maxStack.isEmpty()){
            ListNode curr = maxStack.poll();
            curr.next = null;
            if(head2 == null){
                head2 = curr;
                curr2 = curr;
            }else{
                curr2.next = curr;
                curr2 = curr;
            }
        }

        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        curr1.next = head2;
        return head1;
    }
}
