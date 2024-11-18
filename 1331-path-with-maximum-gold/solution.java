class Solution {
    int[][] grid;
    int[][] visited;

    public int getMaximumGold(int[][] grid) {
        this.visited = new int[grid.length][grid[0].length];
        this.grid = grid;
        int max = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                max = Math.max(recursion(i, j), max);
            }
        }   
        return max;
    }

    private int recursion(int x, int y){
        boolean exp1 = (0 <= x && x < grid.length);
        boolean exp2 = (0 <= y && y < grid[0].length);

        if(!exp1 || !exp2 || grid[x][y] == 0 || visited[x][y] == 1){
            return 0;
        }

        visited[x][y] = 1;
        int val = grid[x][y] + Math.max(recursion(x + 1, y), Math.max(recursion(x - 1, y), Math.max(recursion(x, y + 1), recursion(x, y - 1))));
        visited[x][y] = 0;
        return val;
    }
}
