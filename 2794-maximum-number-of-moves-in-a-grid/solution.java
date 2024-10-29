class Solution {
    int[][] grid;
    HashMap<String, Integer> map = new HashMap<>();
    int[][] dp;

    public int maxMoves(int[][] grid) {
        this.grid = grid;
        dp = new int[grid.length][grid[0].length];
        int max = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0; i < grid.length; i++){
            traverseGrid(i, 0, Integer.MIN_VALUE);
        }
        for(int i = 0; i < grid.length; i++){
            max = Math.max(dp[i][0], max);
        }

        return max - 1;
    }

    private int traverseGrid(int i, int j, int prevVal){
        boolean exp1 = (0 <= i && i < grid.length);
        boolean exp2 = (0 <= j && j < grid[0].length);
        
        if(!exp1 || !exp2 || prevVal >= grid[i][j]){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int max = 1 + Math.max(
            traverseGrid(i - 1, j + 1, grid[i][j]), 
                Math.max(
                    traverseGrid(i, j + 1, grid[i][j]), 
                    traverseGrid(i + 1, j + 1, grid[i][j])
                )
        );
        
        dp[i][j] = max;
        return max;
    }
}
