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
    public ListNode reverseBetween(ListNode head, int leftVal, int rightVal) {
        if(leftVal == rightVal){
            return head;
        }

        ListNode left = head;
        ListNode temp = head;

        Stack<Integer> stack = new Stack<>();

        int count = 1;

        while (left != null) {
            if (count == leftVal)
                break;
            left = left.next;
            count++;
        }

        count = 0;
        temp = left;
        
        while(count <= rightVal - leftVal){
            stack.add(temp.val);
            temp = temp.next;
            count++;
        }

        // System.out.println(stack);

        while(!stack.isEmpty()){
            left.val = stack.pop();
            left = left.next;
        }

        // System.out.println(left.val + " " + right.val);

        return head;
    }
}
