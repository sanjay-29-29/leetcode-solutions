class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        int left = 0, right = 0;
        long sum = 0, max = 0;

        while(left < nums.length && right < nums.length) {
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            sum += nums[right];
            set.add(nums[right]);
            right++;

            if(set.size() == k) {
                max = Math.max(max, sum);
                sum -= nums[left];
                set.remove(nums[left]);
                left++;
            }
        }        

        return max;
    }
}
