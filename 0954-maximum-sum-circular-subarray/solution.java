class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int m = Integer.MIN_VALUE;
        boolean isPos = false;
        int s1 = 0, s2 = 0, totalSum = 0;

        for(int i : nums) {
            if(i > 0) {
                isPos = true;
            }

            if(s1 + i < i) {
                s1 = 0;
            }
            s1 += i;
            max = Math.max(max, s1);
            m = Math.max(m, i);

            if(s2 + i > i) {
                s2 = 0;
            }
            s2 += i;
            min = Math.min(min, s2);

            totalSum += i;
        }

        if(!isPos) {
            return m;
        }

        return Math.max(
            max,
            totalSum -min
        );
    }
}
