class Solution {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums)  {
            set.add(i);
        }

        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> nSet = new HashSet<>();
            for(int j = i; j < nums.length; j++) {
                nSet.add(nums[j]);
                if(nSet.size() == set.size()) {
                    count++;
                }
            }
        }

        return count;
    }
}
