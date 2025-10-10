class Solution {
    int[] dp; 

    public int maximumEnergy(int[] energy, int k) {
        dp = new int[energy.length];
        int res = Integer.MIN_VALUE;

        Arrays.fill(dp, -1);
        
        for(int i = 0; i < energy.length; i++) {
            res = Math.max(recurse(i, energy, k), res);
        }

        return res;
    }

    private int recurse(int i, int[] e, int k) {
        if(i >= e.length) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        dp[i] = e[i] + recurse(i + k, e, k); 
        return dp[i];
    }
}
