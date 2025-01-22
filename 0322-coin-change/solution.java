class Solution {
    private int recursion(int[] coins, int amount, int index, int[][] dp){
        if(index > coins.length - 1){
            return 99999;
        }

        if(amount == 0){
            return 0;
        }

        String key = amount + " " + index;

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        if(amount - coins[index] >= 0){
            int val = Math.min(
                1 + recursion(coins, amount - coins[index], index, dp),
                Math.min(
                    1 + recursion(coins, amount - coins[index], index + 1, dp),
                    recursion(coins, amount, index + 1, dp)
                )
            );
            dp[index][amount] = val;
            return val;
        }

        int val = recursion(coins, amount, index + 1, dp);
        dp[index][amount] = val;
        return val;
    }

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];

        for(int i = 0; i < coins.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int val = recursion(coins, amount, 0, dp);

        if(val == 99999){
            return -1;
        }

        return val;
    }
}
