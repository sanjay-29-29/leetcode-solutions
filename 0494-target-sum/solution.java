class Solution {
    int[] nums;
    int target;

    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums; 
        this.target = target;

        return recursion(0, 0);
    }

    private int recursion(int index, int currSum){
        if(index >= nums.length){
            if(currSum == target){
                return 1;
            }
            return 0;
        }
        // if(target == currSum){
        //     return 1 + recursion(index + 1, nums[index] + currSum) + recursion(index + 1, nums[index] - currSum);
        // }
        return recursion(index + 1, nums[index] + currSum) + recursion(index + 1, currSum - nums[index]);
    }
}
