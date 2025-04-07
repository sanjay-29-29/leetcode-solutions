class Solution {
    public int findMaxFish(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean[][] visited = new boolean[grid.length][grid[0].length];
                res = Math.max(res, dfs(grid, i, j, visited));
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        boolean a = (0 <= i && i < grid.length);
        boolean b = (0 <= j && j < grid[0].length);

        if (!a || !b || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return grid[i][j] +
                dfs(grid, i + 1, j, visited) + dfs(grid, i, j + 1, visited)
                + dfs(grid, i - 1, j, visited) +
                dfs(grid, i, j - 1, visited);
    }
}
