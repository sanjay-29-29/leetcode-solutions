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
    public ListNode deleteDuplicates(ListNode head) {
        class Helper implements Comparable<Helper> {
            ListNode node;

            Helper(ListNode _node) {
                node = _node;
            }

            public int hashCode() {
                return node.val;
            }

            public int compareTo(Helper helper1) {
                return Integer.compare(this.node.val, helper1.node.val);
            }
        }

        Map<Helper, Integer> set = new TreeMap<>();
        ListNode temp = head;

        while (temp != null) {
            Helper h = new Helper(temp);
            set.put(h, set.getOrDefault(h, 0) + 1);
            temp = temp.next;
            h.node.next = null;
        }

        ListNode res = null;
        temp = null;

        for (Object t : set.keySet()) {
            Helper helper = (Helper) t;
            int val = set.get(helper);

            if(val > 1){
                continue;
            }

            if (res == null) {
                res = helper.node;
                temp = helper.node;
            } else {
                temp.next = helper.node;
                temp = temp.next;
            }
        }

        return res;
    }
}
