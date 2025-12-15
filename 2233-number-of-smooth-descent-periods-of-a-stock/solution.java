class Solution {
    public long getDescentPeriods(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        long res = 0, count = 1, val = 0;
        boolean prev = false;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - prices[i] == 1) {
                count += 1;
                prev = true;
            } else {
                if(prev == true) {
                    res += count * (count + 1) / 2;
                    // System.out.println(i + " " + count);
                } else {
                    res += 1;
                }
                prev = false;
                count = 1;
            }
        }

        if(prev == true) {
            res += count * (count + 1) / 2;
            return res;
        }
        return res + 1;
    }
}
