/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int compare(void* num1, void* num2) {
    //printf("%d",*(int *)num1);
    if (*(int*)num1 > *(int*)num2)
        return 1;
    else
        return -1;
}

int* sortArray(int* arr, int numsSize, int* returnSize) {
    qsort(arr, numsSize, sizeof(int), compare);
    *returnSize = numsSize;
    return arr;
}
