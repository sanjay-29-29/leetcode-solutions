class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1){
            return 1;
        }

        int left_p = 0;
        int left = 0;
        int right = 0;

        while(right < nums.length && left < nums.length){
            if(nums[left] == nums[right]){
                right++;
                continue;
            }else{
                nums[left_p ++] = nums[left];
                left = right;
                right++;
            }
        }
        nums[left_p ++] = nums[left];
        return left_p;
    }
}
