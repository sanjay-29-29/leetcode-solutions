/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if(head==NULL || head->next==NULL){
        return head;
    }
    
    struct ListNode *slow = head;
    struct ListNode *fast = head;
    
    while(fast!=NULL){
        if(fast->val == slow->val){
            fast = fast->next;
        }else{
            slow -> next = fast;
            slow = fast;
        }
    }
    slow->next=NULL;
    return head;
}
