class Solution {
    public int countHillValley(int[] nums) {
        int count = 0, i = 1;
        while(i < nums.length - 1) {
            if(nums[i] == nums[i + 1]) {
                int prev = nums[i - 1];
                while(i < nums.length - 2 && nums[i] == nums[i + 1]) {
                    i++;
                }
                if(prev > nums[i] && nums[i] < nums[i + 1]) {
                    count++;
                } else if(nums[i] > prev && nums[i + 1] < nums[i]) {
                    count++;
                }
            } else {
                if(nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                    count++;
                } else if(nums[i] < nums[i - 1] && nums[i + 1] > nums[i]) {
                    count++;
                }
            }
            i++;
        }

        return count;
    }
}
