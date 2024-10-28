class Solution {
    int perimeter;
    int[][] grid;
    int[][] visited;

    public int islandPerimeter(int[][] grid) {
        this.grid = grid;
        this.visited = new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    bfs(i, j);
                }
            }
        }    
        return perimeter;
    }

    private void bfs(int i, int j){
        boolean exp1 = (0 <= i && i < grid.length);
        boolean exp2 = (0 <= j && j < grid[0].length);

        if(!exp1 || !exp2 || grid[i][j] == 0){
            perimeter++;
            return;
        }
        
        if(visited[i][j] == 1){
            return;
        }

        visited[i][j] = 1;
        
        bfs(i - 1, j);
        bfs(i + 1, j);
        bfs(i, j + 1);
        bfs(i, j - 1);
    }
}
