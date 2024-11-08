class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] returnArray = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            returnArray[i] = -1;
            for(int j = 0; j < nums.length; j++){
                int index = (i + j + 1) % nums.length;
                if(nums[i] < nums[index]){
                    returnArray[i] = nums[index];
                    break;
                }
            }
        }

        return returnArray;
    }
}

