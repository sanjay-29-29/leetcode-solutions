class Solution {
    int[][] dp;
    Map<String, Integer> map = new HashMap<>();

    public int maxProfit(int[] prices) {
        dp = new int[prices.length + 1][prices.length + 1];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxProfit(prices, 0, false, -1);
    }

    private int maxProfit(int[] prices, int index, boolean status, int prevIndex) {
        if (index >= prices.length) {
            return 0;
        }

        // String key = index + " " + prevIndex;
        // if(map.containsKey(key)) {
        //     return map.get(key);
        // }
        int prevOff = prevIndex + 1;
        if (dp[index][prevOff] != -1) {
            return dp[index][prevOff];
        }

        if (status) {
            int val = Math.max(
                    maxProfit(
                            prices, index + 1, status, prevIndex),
                    prices[index] - prices[prevIndex] + maxProfit(
                            prices, index + 2, false, -1));
            dp[index][prevIndex + 1] = val;
            // map.put(key, val);
            return val;
        }

        int val = Math.max(
                maxProfit(
                        prices, index + 1, true, index),
                maxProfit(
                        prices, index + 1, false, prevIndex));
        dp[index][prevIndex + 1] = val;
        // map.put(key, val);
        return val;
    }
}
