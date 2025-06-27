class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return recurse(grid, 0, 0);
    }

    private int recurse(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if(i >= m || i < 0 || j >= n || j < 0){
            return Integer.MAX_VALUE;
        }
        if(i == m -1 && j == n-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int val = grid[i][j] + Math.min(recurse(grid,i+1,j),recurse(grid, i,j+1));
        dp[i][j] = val;
        return val;
    }
}
