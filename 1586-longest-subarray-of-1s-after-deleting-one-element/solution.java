class Solution {
    public int longestSubarray(int[] nums) {
       int left = 0, right = 0, res = 0;
       boolean zero = false;

       while(left < nums.length && right < nums.length) {
            while(nums[right] == 0 && zero) {
                if(nums[left] == 0) {
                    zero = false;
                }
                left++;
            }
            if(nums[right] == 0) {
                zero = true;
            }
            res = Math.max(res, right - left);
            right++;
       } 
       return res;
    }
}
