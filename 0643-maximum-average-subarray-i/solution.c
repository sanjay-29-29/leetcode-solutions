double findMaxAverage(int* nums, int numsSize, int k) {
    double average = 0;
    double max = 0;

    if(numsSize <= k){
        for(int i=0;i<numsSize;i++){
            average += nums[i];
        }
        return average/k;
    }

    for(int i=0;i<k;i++){
        max += nums[i];
        average += nums[i];
    }

    for(int i=1;i<numsSize-k+1;i++){
        average -= nums[i-1]; 
        average += nums[i+k-1];
        if(average > max){
            max = average;
        }
    }

    return max/k;
}
