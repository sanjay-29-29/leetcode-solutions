class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int one = 0;
        boolean flag = false;

        for(int i = 0; i < nums.length; i++) {
            if(!flag && nums[i] == 1) {
                flag = true;
                one = 0;
            } else if(nums[i] == 1){
                if(one < k) {
                    return false;
                }
                one = 0;
            } else {
                one++;
            }
        }

        return true;
    }
}
