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
    public ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = null;
        ListNode curr = null;

        while (head != null) {
            ListNode temp = head.next;

            if (stack.size() == k) {
                // System.out.println(stack);
                ListNode newSemi = null;
                ListNode temp2 = null;

                while (!stack.isEmpty()) {
                    if (newSemi == null) {
                        newSemi = stack.pop();
                        temp2 = newSemi;
                    } else {
                        temp2.next = stack.pop();
                        temp2 = temp2.next;
                    }
                }

                if (newHead == null) {
                    newHead = newSemi;
                    curr = temp2;
                    curr.next = null;
                } else {
                    curr.next = newSemi;
                    curr = temp2;
                    curr.next = null;
                }

            } else {
                stack.push(head);
                head = temp;
            }
        }

        if (stack.size() == k) {
            ListNode newSemi = null;
            ListNode temp2 = null;

            while (!stack.isEmpty()) {
                if (newSemi == null) {
                    newSemi = stack.pop();
                    temp2 = newSemi;
                } else {
                    temp2.next = stack.pop();
                    temp2 = temp2.next;
                }
            }

            if (newHead == null) {
                newHead = newSemi;
                curr = temp2;
                curr.next = null;
            } else {
                curr.next = newSemi;
                curr = temp2;
                curr.next = null;
            }
        }

        List<ListNode> list = new LinkedList<>(stack);

        for (ListNode l : list) {
            if (newHead == null) {
                newHead = l;
                curr = newHead;
            } else {
                curr.next = l;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
