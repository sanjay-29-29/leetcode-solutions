class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int diff = nums[i] - i;
            int val = map.getOrDefault(diff, 0);
            count += i - val;
            map.put(diff, map.getOrDefault(diff, 0) + 1);
        }
        return count;
    }
}
