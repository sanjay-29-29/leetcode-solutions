class Solution {
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long prefix = 0;
        int count = 0;

        for(int i = nums.length - 1; i >= 0; i--){
            prefix += nums[i];
            if(prefix > 0){
                count++;
            }else{
                break;
            }
        }

        return count;
    }
}
