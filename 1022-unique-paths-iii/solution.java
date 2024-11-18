class Solution {
    int[][] grid;
    int[][] visited;
    int visitedCellCount;
    int blockage;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.visited = new int[grid.length][grid[0].length];
        int startX = 0, startY = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
                if (grid[i][j] == -1) {
                    visited[i][j] = 1;
                    blockage++;
                }
            }
        }

        return recursion(startX, startY);
    }

    private int recursion(int x, int y) {
        boolean exp1 = (0 <= x && x < grid.length);
        boolean exp2 = (0 <= y && y < grid[0].length);
        
        if (!exp1 || !exp2 || grid[x][y] == -1 || visited[x][y] == 1) {
            return 0;
        }
    
        if (grid[x][y] == 2 && (visitedCellCount + blockage + 1) == (grid.length * grid[0].length)) {
            return 1;
        }

        visited[x][y] = 1;
        visitedCellCount++;

        int val = recursion(x + 1, y) + recursion(x - 1, y)
                + recursion(x, y + 1) + recursion(x, y - 1);

        visitedCellCount--;
        visited[x][y] = 0;

        return val;
    }
}

