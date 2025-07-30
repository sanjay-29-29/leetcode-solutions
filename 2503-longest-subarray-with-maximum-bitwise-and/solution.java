class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0, res = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int i = 0;

        while(i < nums.length) {
            int j = 0;
            while(i + j < nums.length && nums[i + j] == max) {
                j++;
                res = Math.max(j, res);
            }
            i += j;
            i++;
        }

        return res;
    }
}
