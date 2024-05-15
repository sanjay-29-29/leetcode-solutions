int* twoSum(int* numbers, int numbersSize, int target, int* returnSize) {
    int l = 0;
    int r = numbersSize - 1;

    while (l < r) {
        if (numbers[l] + numbers[r] == target) {
            int *return_array = (int *)malloc(2 * sizeof(int));
            return_array[0] = l + 1;  // Adjust for 1-based index
            return_array[1] = r + 1;  // Adjust for 1-based index
            *returnSize = 2;
            return return_array;
        } else if (numbers[l] + numbers[r] < target) {
            l++;
        } else {
            r--;
        }
    }

    // If no solution found
    *returnSize = 0;
    return NULL;
}
