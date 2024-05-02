int maxProfit(int* prices, int pricesSize) {
    if (pricesSize == 0) return 0; // Handle empty array case

    int minPrice = prices[0];
    int maxProfit = 0;

    for (int i = 1; i < pricesSize; i++) {
        // Update minimum price if a lower price is encountered
        if (prices[i] < minPrice) {
            minPrice = prices[i];
        }
        // Update maximum profit if selling at current price yields higher profit
        else if (prices[i] - minPrice > maxProfit) {
            maxProfit = prices[i] - minPrice;
        }
    }

    return maxProfit;
}

