class Solution {
    public int maximumCount(int[] nums) {
        int n = 0;
        int p = 0;

        for(int i : nums){
            if(i > 0){
                p++;
            }
            if(i < 0){
                n++;
            }
        }

        return Math.max(n, p);
    }
}
