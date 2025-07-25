class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sum = 0, min = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0 && !set.contains(nums[i])) {
                sum += nums[i];
            }
            set.add(nums[i]);
            min = Math.max(nums[i], min);
        }
        if(min < 0)  return min;  return sum;
    }
}
