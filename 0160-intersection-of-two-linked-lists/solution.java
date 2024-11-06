/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    Set<ListNode> set = new HashSet<>();

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        while(temp1 != null){
            if(set.contains(temp1)){
                return temp1;
            }else{
                set.add(temp1);
                temp1 = temp1.next;
            }
        }
        while(temp2 != null){
            if(set.contains(temp2)){
                return temp2;
            }else{
                set.add(temp2);
                temp2 = temp2.next;
            }
        }

        return null;    
    }
}
