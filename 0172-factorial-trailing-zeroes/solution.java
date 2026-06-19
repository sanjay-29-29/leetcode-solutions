class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        int twoCount = 0, fiveCount = 0;

        for(int k = n; k >= 1; k--) {
            int i = k;

            while(true) {
                if(i % 5 == 0) {
                    i /= 5;
                    fiveCount += 1;
                    continue;
                }
                if(i % 2 == 0) {
                    i /= 2;
                    twoCount += 1;
                    continue;
                }
                
                break;
            }
        }

        // System.out.println(twoCount + " " + fiveCount);

        return Math.min(twoCount, fiveCount);
    }
}
