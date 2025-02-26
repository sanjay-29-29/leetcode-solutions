class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        currSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            currSum = Math.min(currSum + nums[i], nums[i]);
            minSum = Math.min(minSum, currSum);
        }

        // System.out.println(maxSum);
        // System.out.println(minSum);

        return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
