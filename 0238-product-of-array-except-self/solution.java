class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        prefix[nums.length - 1] = 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            prefix[i] = nums[i + 1] * prefix[i + 1];
        }

        suffix[0] = 1;

        for(int i = 1; i < nums.length; i++){
            suffix[i] = suffix[i - 1] * nums[i - 1];
        }

        for(int i = 0; i < nums.length; i++){
            nums[i] = prefix[i] * suffix[i];
        }

        return nums;
    }
}
