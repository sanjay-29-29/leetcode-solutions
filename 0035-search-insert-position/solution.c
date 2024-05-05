int searchInsert(int* nums, int numsSize, int target) {
    int left,right,middle;
        left = 0;
        right = numsSize - 1;
    while( left <= right ){
        middle = (left+right)/2;
        if(nums[middle] == target){
            return middle;
        }
        else if(nums[middle] < target){
            left = middle+1;
        }
        else{
            right = middle-1;
        }
    }
    return left;
}
