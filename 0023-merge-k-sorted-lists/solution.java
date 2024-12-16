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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> Integer.compare(a, b));

        for (int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                heap.add(curr.val);
                curr = curr.next;
            }
        }

        // System.out.println(heap);

        if (heap.size() == 0) {
            return null;
        }

        ListNode head = null;
        ListNode curr = null;

        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (head == null) {
                head = new ListNode(val);
                curr = head;
            } else {
                curr.next = new ListNode(val);
                curr = curr.next;
            }
        }
        return head;

    }
}
