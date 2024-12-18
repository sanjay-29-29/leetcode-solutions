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

        ListNode temp1 = l1;
        ListNode temp2 = l2;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(temp1 != null){
            stack1.push(temp1);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            stack2.push(temp2);
            temp2 = temp2.next;
        }

        ListNode curr = null;
        ListNode prev = null;
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            curr = new ListNode();
            curr.next = prev;
            int val1 = 0;

            if(!stack1.isEmpty()){
                val1 += stack1.pop().val;
            }
            if(!stack2.isEmpty()){
                val1 += stack2.pop().val;
            }

            val1 += carry;

            if(val1 >= 10){
                val1 %= 10;
                carry = 1;
            }else{
                carry = 0;
            }

            curr.val = val1;
            prev = curr;
        }

        if(carry == 1){
            ListNode l = new ListNode(1);
            l.next = curr;
            return l;
        }

        return curr;

        // System.out.println(temp1.val);
        // System.out.println(temp2.val);
    }
}
