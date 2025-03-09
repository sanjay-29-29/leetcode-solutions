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
    public int pairSum(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;

        while(temp != null){
            list.add(temp);
            temp = temp.next;
        }

        int n = list.size();
        int i = 0;
        int maxSum = 0;

        while(i <= n / 2){
            ListNode list1 = list.get(i);
            ListNode list2 = list.get(n - i - 1);

            maxSum = Math.max(list1.val + list2.val, maxSum);
            i++;
        }

        return maxSum;
    }
}
