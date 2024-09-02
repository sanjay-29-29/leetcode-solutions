class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(slow<nums.length && fast<nums.length){
            if(nums[slow] != 0){
                slow++;
                continue;
            }
            if(nums[fast] == 0 || fast<slow){
                fast++;
                continue;
            }
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
        }
    }
}
