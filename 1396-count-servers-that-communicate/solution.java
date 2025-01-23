class Solution {
    private int isSingleServer(int[][] grid, int row, int col){
        for(int i = 0; i < grid.length; i++){
            if(grid[i][col] == 1 && (i != row)){
                return 0;
            }
        }

        for(int i = 0; i < grid[0].length; i++){
            if(grid[row][i] == 1 && (i != col)){
                return 0;
            }
        }

        return 1;
    }

    public int countServers(int[][] grid) {
        int count = 0;
        int singleServerCount = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    singleServerCount += isSingleServer(grid, i, j);
                    count++;
                }
            }
        }

        return count - singleServerCount;
    }
}
