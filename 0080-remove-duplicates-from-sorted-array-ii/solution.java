class Solution {
    public int removeDuplicates(int[] nums) {
        int fast = 0;
        int slow = 0;
        int count = 0;
        int prev = 0;

        while(fast < nums.length && slow < nums.length){
            if(nums[slow] == nums[fast]){
                fast++;
                count++;
                continue;
            }else{
                if(count >= 2){
                    nums[prev++] = nums[slow];
                    nums[prev++] = nums[slow];
                }else{
                    nums[prev++] = nums[slow];
                }
                slow = fast;
                count = 0;
            }
        }

        // System.out.println(count);
        if(count >= 2){
            nums[prev++] = nums[slow];
            nums[prev++] = nums[slow];
        }else{
            nums[prev++] = nums[slow];
        }

        return prev;
    }
}
