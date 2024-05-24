int split_num_sum(int num){
    int sum=0,rem;
    while(num>0){
        rem = num % 10;
        sum += rem;
        num /= 10;
    }
    return sum;
}

int differenceOfSum(int* nums, int numsSize) {
    int normal_sum = 0;
    int split_sum = 0;
    for(int i=0;i<numsSize;i++){
        normal_sum += nums[i];
        split_sum += split_num_sum(nums[i]);
    }
    if(normal_sum - split_sum > 0){
        return normal_sum - split_sum;
    }
    else{
        return -(normal_sum - split_sum);
    }
}


