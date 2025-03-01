class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        int p1 = 0;
        int p2 = 0;

        for(int i = 0; i < nums.length; i++){
            int j = i + 1;
            boolean flag = false;
            while(nums[i] == 0 && j < nums.length){
                if(nums[j] != 0){
                    flag = true;
                    break;
                }
                j++;
            }
            if(flag){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        return nums;
    }
}
