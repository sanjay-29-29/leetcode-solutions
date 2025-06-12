class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == nums.length - 1) {
                max = Math.max(max, Math.abs(nums[0] - nums[nums.length - 1]));
            }
            else {
                max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
            }
        }

        return max;
    }
}
