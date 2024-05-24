#include <stdlib.h>

int* shuffle(int* nums, int numsSize, int n, int* returnSize) {
    int *return_array = (int *) malloc(sizeof(int) * numsSize * 2);
    int index = 0;

    for (int i = 0; i < n; i++) {
        return_array[index++] = nums[i];
        return_array[index++] = nums[i + n];
    }

    *returnSize = numsSize;
    return return_array;
}

