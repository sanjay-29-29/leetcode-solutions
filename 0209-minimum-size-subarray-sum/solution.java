class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, currSum = 0, dist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            while (currSum >= target) {
                dist = Math.min(dist, i - left + 1);
                currSum -= nums[left++];
            }
        }

        if (dist == Integer.MAX_VALUE) {
            return 0;
        }

        return dist;
    }
}
