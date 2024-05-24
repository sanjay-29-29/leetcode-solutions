#include <stdbool.h>

bool isMonotonic(int* nums, int numsSize) {
    bool increasing = true;
    bool decreasing = true;

    for (int i = 0; i < numsSize - 1; i++) {
        if (nums[i] > nums[i + 1]) {
            increasing = false;
            break;
        }
    }

    for (int i = 0; i < numsSize - 1; i++) {
        if (nums[i] < nums[i + 1]) {
            decreasing = false;
            break;
        }
    }

    return increasing || decreasing;
}

