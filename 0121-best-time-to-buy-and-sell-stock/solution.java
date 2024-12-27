class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = 100001;
        int maxPrice = 0;

        for(int i = 0; i < prices.length; i++){
            minPrice = Math.min(minPrice, prices[i]);
            int currProfit = prices[i] - minPrice;
            maxPrice = Math.max(maxPrice, currProfit);
        }

        return maxPrice;
    }
}
