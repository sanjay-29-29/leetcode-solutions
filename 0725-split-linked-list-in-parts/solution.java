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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] res = new ListNode[k];
        int[] size = new int[k];
        int listSize = 0;

        ListNode temp = head;
        while(temp != null) {
            temp = temp.next;
            listSize++;
        }

        int j = 0;

        while(listSize > 0) {
            size[j]++;
            j++;
            listSize--;
            j = j % res.length; 
        }

        // for(int i : size) {
        //     System.out.print(i + " ");
        // }

        temp = head;
        for(int i = 0; i < res.length; i++) {
            res[i] = temp;
            ListNode prev = null;
            for(j = 0; j < size[i]; j++) {
                prev = temp;
                temp = temp.next;
            }
            if(prev == null) {
                continue;
            }
            prev.next = null;
        }

        return res;
    }
}
