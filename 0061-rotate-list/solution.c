/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* rotateRight(struct ListNode* head, int k) {
    if (head == NULL || head->next == NULL || k == 0) {
        return head; 
    }
    
    int list_length = 1;
    struct ListNode* tail = head;
    
    while (tail->next != NULL) {
        tail = tail->next;
        list_length++;
    }
   
    k = k % list_length;
    
    if (k == 0) {
        return head;
    }
    
    struct ListNode* new_head = head;
    for (int i = 0; i < list_length - k - 1; i++) {
        new_head = new_head->next;
    }
    
    tail->next = head; 
    head = new_head->next; 
    new_head->next = NULL; 
    
    return head;
}

