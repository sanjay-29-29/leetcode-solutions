class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(currSum < 0) currSum = 0;
            currSum = currSum + nums[i];
            max = Math.max(max, currSum);
        }

        return max;
    }
}
