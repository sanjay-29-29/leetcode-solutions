class Solution {
    public int[] finalPrices(int[] prices) {
        int[] retArray = new int[prices.length];

        for(int i = 0; i < prices.length; i++){
            int discount = prices[i];
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] <= prices[i]){
                    discount -= prices[j];
                    break;
                }
            }
            retArray[i] = discount;
        }        

        return retArray;
    }
}
