class Solution {
    public int partitionArray(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            int j = i;
            while(j < nums.length && Math.abs(nums[i] - nums[j]) <= k) {
                j++;
            }
            i = j - 1;
            res++;
        }

        return res;    
    }
}
