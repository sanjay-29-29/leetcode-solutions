/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* getConcatenation(int* nums, int numsSize, int* returnSize) {
    int *newarray = (int*)malloc(2 * numsSize * sizeof(int));

    for(int i=0; i< 2*numsSize ; i++){
        int var = i%numsSize;
        newarray[i] = nums[var]; 
    }
    *returnSize = 2 * numsSize;
    return newarray;
}
