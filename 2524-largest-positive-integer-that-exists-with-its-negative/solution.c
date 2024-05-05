int findMaxK(int* nums, int numsSize) {
    int max = 0;
    for(int i = 0 ; i < numsSize ; i++){
        for(int j = 0 ; j<numsSize; j++){
            if(nums[i]>max && nums[i]==-nums[j]){
                max = nums[i];
            }
        }
    }
    if(max!=0){
        return max;
    }
    else{
        return -1;
    }
}
