class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0, right = 0, max = 0, curr = 0;
        Set<Integer> set = new HashSet<>();

        while(left < nums.length && right < nums.length) {
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                curr -= nums[left++];
                // System.out.println(left + " " + right);
            }
            set.add(nums[right]);
            curr += nums[right++];
            max = Math.max(curr, max);
        }
        
        return max;
    }
}
