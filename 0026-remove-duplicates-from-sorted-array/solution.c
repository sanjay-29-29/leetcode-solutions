int removeDuplicates(int* nums, int numsSize) {
    if (numsSize == 0) {
        return 0;
    }
    int slowpointer = 0;
    for (int fastpointer = 1; fastpointer < numsSize; fastpointer++) {
        if (nums[fastpointer] != nums[slowpointer]) {
            slowpointer++;
            nums[slowpointer] = nums[fastpointer];
        }
    }
    return slowpointer + 1;
}

