class Solution {
    public int minOperations(int[] nums, int k) {
        for(int i : nums) {
            if(i < k) {
                return -1;
            }
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > k) {
                set.add(nums[i]);
            }
        }
        return set.size();
    }
}
