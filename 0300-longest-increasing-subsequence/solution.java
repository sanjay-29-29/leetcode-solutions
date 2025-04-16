class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < nums.length; i++) {
            int max = dp[i];
            for(int j = 0; j <= i; j++) {
                if(nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int max = 1;
        for(int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }
}
