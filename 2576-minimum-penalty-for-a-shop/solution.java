class Solution {
    public int bestClosingTime(String customers) {
        int[] profit = new int[customers.length()];
        int max = 0, idx = 0, currProfit = 0;

        for(int i = 0; i < customers.length(); i++) {
            char c = customers.charAt(i);
            if(c == 'Y') {
                ++currProfit;
            } else {
                --currProfit;
            }
            if(currProfit > max) {
                max = currProfit;
                idx = i + 1;
            }
        }

        return idx;
    }
}
