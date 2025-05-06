class Solution {
    public int longestOnes(int[] nums, int k) {
        int inCount = 0, left = 0, max = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                inCount++;
            }

            while(inCount > k) {
                if(nums[left++] == 0) {
                    inCount--;
                }
            }

            max = Math.max(i - left + 1, max);
        } 

        return max;
    }
}
