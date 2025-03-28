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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = getMid(head);

        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }

        while(!stack.isEmpty()){
            ListNode n = stack.pop();
            n.next = null;
            n.next = head.next;
            head.next = n;
            head = head.next.next;
            // System.out.println(n.val);
        } 
        head.next.next = null;
    }

    public ListNode getMid(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode slow = node, fast = node;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
