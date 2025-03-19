class Solution {
    public int minOperations(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 0) {
                count++;
                for(int j = 0; j < 3; j++){
                    nums[i + j] = nums[i + j] ^ 1; 
                }
            }
        }


        for(int i = nums.length - 2; i < nums.length; i++){
            if(nums[i] != 1){
                return -1;
            }
        }

        return count;
    }
}
