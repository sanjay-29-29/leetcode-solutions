class Solution {
    int[][] grid;
    // int[][] visited;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        // this.visited = new int[grid.length][grid[0].length];
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            bfs(i, 0);
            bfs(i, grid[0].length - 1);
        }

        for(int i = 0; i < grid[0].length; i++){
            bfs(0, i);
            bfs(grid.length - 1, i);
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j) {
        boolean exp1 = (0 <= i && i < grid.length);
        boolean exp2 = (0 <= j && j < grid[0].length);

        if (!exp1 || !exp2) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        if(grid[i][j] == 1){
            grid[i][j] = 0;
            bfs(i + 1, j);
            bfs(i - 1, j);
            bfs(i, j + 1);
            bfs(i, j - 1);
        }

    }
}
