class Solution {
    int[][][] dp;

    public int numberOfPaths(int[][] grid, int k) {
        dp = new int[grid.length][grid[0].length][k];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return recurse(grid, 0, 0, k, 0);
    }

    private int recurse(int[][] grid, int i, int j, int k, int sum) {
        boolean a = (0 <= i && i < grid.length);
        boolean b = (0 <= j && j < grid[0].length);

        if(!a || !b) {
            return 0;
        }

        int rem = (sum + grid[i][j]) % k;
        if(dp[i][j][rem] != -1) {
            return dp[i][j][rem];
        }

        if(i == grid.length - 1  && j == grid[0].length - 1) {
            if((sum + grid[i][j]) % k == 0) {
                return 1;
            }
            return 0;
        }

        int val = (
            recurse(grid, i + 1, j, k, sum + grid[i][j]) + 
            recurse(grid, i, j + 1, k, sum + grid[i][j])) % 1000000007;
        dp[i][j][rem] = val;
        return val;
    }
}
