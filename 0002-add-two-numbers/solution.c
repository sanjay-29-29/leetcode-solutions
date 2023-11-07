/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {

    int carry = 0; // Initialize carry to 0
    struct ListNode dummy; // Create a dummy node to simplify the code
    struct ListNode *current = &dummy; // Create a pointer to the dummy node

    while (l1 || l2 || carry) {
        int sum = carry;

        if (l1) {
            sum += l1->val;
            l1 = l1->next;
        }

        if (l2) {
            sum += l2->val;
            l2 = l2->next;
        }

        carry = sum / 10; // Update the carry for the next iteration
        int digit = sum % 10;

        // Create a new node for the result
        struct ListNode *newNode = (struct ListNode *)malloc(sizeof(struct ListNode));
        newNode->val = digit;
        newNode->next = NULL;

        // Link the new node to the result list
        current->next = newNode;
        current = newNode;
    }

    return dummy.next;
}
