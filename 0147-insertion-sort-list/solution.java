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
    ListNode res;

    public ListNode insertionSortList(ListNode head) {
        while(head != null){
            ListNode temp = head.next;
            insert(head);
            head = temp;    
        }

        return res;
    }

    private void insert(ListNode ele){
        if(ele == null){
            return;
        }

        if(res == null){
            res = ele;
            ele.next = null;
            return;
        }

        ele.next = null;

        ListNode temp = res;
        ListNode prev = null;

        while(temp != null) {
            if(temp.val > ele.val){
                if(prev != null){
                    prev.next = ele;
                    ele.next = temp;
                }else{ 
                    ele.next = temp;
                    res = ele;
                }
                return;
            }

            prev = temp;
            temp = temp.next;
        }

        prev.next = ele;
        return;
    }
}
