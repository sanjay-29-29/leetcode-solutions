class Solution {
    public int[] buildArray(int[] nums) {
        int[] res = new int[nums.length];
        int k = 0;
        for(int i : nums) {
            res[k++] = nums[i];
        }
        return res;
    }
}
