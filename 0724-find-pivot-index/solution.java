class Solution {
    public int pivotIndex(int[] nums) {
        int[] sumLeft = new int[nums.length];
        int[] sumRight = new int[nums.length];
        
        int l_sum = 0;
        int r_sum = 0;

        for(int i=0;i<nums.length;i++){
            sumLeft[i] = l_sum;
            l_sum += nums[i];
            
            sumRight[nums.length-i-1] = r_sum;
            r_sum += nums[nums.length-i-1];
        }

        for(int i=0;i<nums.length;i++){
            if(sumRight[i] == sumLeft[i]){
                return i;
            }
         }

        return -1;
    }
}
