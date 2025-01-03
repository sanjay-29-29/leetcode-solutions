class Solution {
    public int waysToSplitArray(int[] nums) {
        int count = 0;
        long[] prefix = new long[nums.length];
        
        long sum = 0; 

        for(int i = nums.length - 1; i >= 0; i--){
            sum += nums[i];
            prefix[i] = sum;
            // System.out.println(sum);
        }

        sum = 0;
        
        for(int i = 0; i < nums.length - 1; i++){
            sum += nums[i];
            if(sum >= prefix[i + 1]){
                count++;
            }
        }

        return count;
    }
}
