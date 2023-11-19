struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL) {
        // If the list is empty or has only one node, no swapping needed
        return head;
    }

    struct ListNode *dummy = malloc(sizeof(struct ListNode));
    dummy->next = head;
    struct ListNode *prev = dummy;

    while (prev->next != NULL && prev->next->next != NULL) {
        struct ListNode *first = prev->next;
        struct ListNode *second = prev->next->next;

        // Swapping
        prev->next = second;
        first->next = second->next;
        second->next = first;

        // Move to the next pair
        prev = first;
    }

    head = dummy->next;
    free(dummy);
    return head;
}

