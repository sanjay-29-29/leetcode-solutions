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
    public ListNode sortList(ListNode head) {
        // System.out.println(findMid(head) == null ? -1 : findMid(head).val);
        return sort(head);
    }

    private ListNode sort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode left = sort(head);
        ListNode right = sort(mid);
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode res = null, curr = null;

        while(left != null && right != null){
            if(left.val < right.val){
                if(res == null){
                    res = left;
                    curr = left;
                }else{
                    curr.next = left;
                    curr = curr.next;
                }
                left = left.next;
            }
            else{
                if(res == null){
                    res = right;
                    curr = right;
                }else{
                    curr.next = right;
                    curr = curr.next;
                }
                right = right.next;
            }
        }

        while(left != null){
            curr.next = left;
            left = left.next;
            curr = curr.next;
        }

        while(right != null){
            curr.next = right;
            right = right.next;
            curr = curr.next;
        }

        return res;
    }

    private ListNode findMid(ListNode head){
        if(head == null){
            return null;
        }

        ListNode prev = head;
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        } 

        prev.next = null;
        return slow;
    }
}
