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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start1 = list1;
        ListNode end1 = list1;

        int i = 0;
        while(start1 != null){
            if(i == a - 1){
                break;
            }
            start1 = start1.next;
            i++;
        }

        i = 0;
        while(end1 != null){
            if(i == b){
                break;
            }
            end1 = end1.next;
            i++;
        } 


        ListNode end2 = list2;
        while(end2.next != null){
            end2 = end2.next;
        }

        start1.next = list2;
        end2.next = end1.next;

    
        return list1;
    }
}
