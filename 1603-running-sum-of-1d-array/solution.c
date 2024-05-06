int* runningSum(int* nums, int numsSize, int* returnSize){
    int *return_array = (int *) malloc (sizeof(int) * numsSize);
    int sum = 0;
    for(int i=0;i<numsSize;i++){
        sum += nums[i];
        return_array[i] = sum;
    }
    *returnSize = numsSize;
    return return_array;
}
