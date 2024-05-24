int smallestEqual(int* nums, int numsSize) {
    int min = 0;
    int i = 0;
    for(int i=0;i<numsSize;i++){
        if( i % 10 == nums[i]){
            return i;
            break;
        }
    }
    return -1;
}
