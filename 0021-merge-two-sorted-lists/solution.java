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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }

        if(list2 == null){
            return list1;
        }

        ListNode currList = null;
        ListNode curr = null;
        
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                if(currList == null){
                    currList = temp1;
                    curr = temp1;
                    temp1 = temp1.next;
                }else{
                    curr.next = temp1;
                    curr = curr.next;
                    temp1 = temp1.next;
                }
            }else{
                 if(currList == null){
                    currList = temp2;
                    curr = temp2;
                    temp2 = temp2.next;
                }else{
                    curr.next = temp2;
                    curr = curr.next;
                    temp2 = temp2.next;
                }
            }
        }

        if(temp1 != null){
            curr.next = temp1;
        }

        if(temp2 != null){
            curr.next = temp2;
        }

        return currList;

}}
