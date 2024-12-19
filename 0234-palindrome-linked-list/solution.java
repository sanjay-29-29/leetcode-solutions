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
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while(temp != null){
            stack.add(temp);
            temp = temp.next;
        }

        temp = head;

        while(!stack.isEmpty() && temp != null){
            if(!(stack.pop().val == temp.val)){
                return false; 
            }
            temp = temp.next;
        }

        return true;
    }
}
