class Solution {
    int[] prices;
    Map<String, Integer> map = new HashMap<>();

    public int maxProfit(int[] prices) {
        this.prices = prices;
        return stock(0, false, 0);
    }

    private int stock(int index, boolean holding, int prevPrice) {
        if (index > prices.length - 1) {
            return 0;
        }

        String key = index + " " + holding + " " + prevPrice;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int val = 0;
        if (holding) {
            if(prices[index] - prevPrice > 0)
            val = Math.max(prices[index] - prevPrice + stock(index + 1, false, 0),
                    stock(index + 1, true, prevPrice));
        } else {
            val = Math.max(stock(index + 1, true, prices[index]), stock(index + 1, false, 0));
        }

        map.put(key, val);
        return val;
    }
}
