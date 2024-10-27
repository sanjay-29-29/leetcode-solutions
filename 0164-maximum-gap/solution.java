class Solution {
    public int maximumGap(int[] nums) {
        int max = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            int num = nums[i+1] - nums[i];
            max = Math.max(max, num);
        }
        return max;
    }
}
