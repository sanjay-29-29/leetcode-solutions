class Solution {
    int[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 != 0) {
            return false;
        }

        dp = new int[nums.length][sum / 2];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }

        return test(nums, 0, 0, sum / 2);
    }

    public boolean test(int[] nums, int index, int currSum, int targetSum) {
        if (currSum == targetSum) {
            return true;
        }
        
        if(currSum > targetSum) {
            return false;
        }

        if (nums.length <= index) {
            return false;
        }

        if(dp[index][currSum] != -1) {
            if(dp[index][currSum] == 1){
                return true;
            }
            return false;
        }

        boolean val1 = test(nums, index + 1, currSum + nums[index], targetSum);
        boolean val2 = test(nums, index + 1, currSum, targetSum);

        if(val1 || val2) {
            dp[index][currSum] = 1;
        }
        dp[index][currSum] = 0;

        return val1 || val2;
    }
}
