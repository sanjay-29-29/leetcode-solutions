class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        while(slow<nums.length && fast<nums.length){
            if(!(nums[slow]%2 != 0 && (slow+1)%2 != 0)){
                slow++;
                continue;
            }
            if(!(nums[fast]%2 == 0 && (fast+1)%2 == 0)){
                fast++;
                continue;
            }
            int temp = nums[slow];
            nums[slow] = nums[fast];
            nums[fast] = temp;
            slow++;
            fast++;
        }
        return nums;
    }
}
