class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(!set.contains(num - 1)){
                int tempCount = 0;
                while(set.contains(num)){
                    tempCount++;
                    count = Math.max(count, tempCount);
                    num++;
                }
            }
        }

        return count;
    }
}
