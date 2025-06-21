class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int[] i : accounts) {
            int curr = 0;
            for(int j : i) {
                curr += j;
            }
            max = Math.max(max, curr);
        }

        return max;
    }
}
