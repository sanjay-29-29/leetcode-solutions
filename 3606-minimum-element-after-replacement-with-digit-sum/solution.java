class Solution {
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int i : nums) {
            min = Math.min(min, digitSum(i));
        }

        return min;
    }

    public int digitSum(int i) {
        int res = 0;

        while(i > 0) {
            res += i % 10;
            i /= 10;
        } 

        return res;
    }
}
