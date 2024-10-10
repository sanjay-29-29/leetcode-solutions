class Solution {
    HashMap<String, Integer> map;
    int row; 
    int col;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        map = new HashMap<>();
        row = obstacleGrid.length;
        col = obstacleGrid[0].length;
        return recursion(obstacleGrid, 0, 0);
    
    }
    private int recursion(int[][] obstacleGrid, int m, int n) {
        if (m > row-1 || n > col-1) { 
            return 0;
        }
        if (obstacleGrid[m][n] == 1) { 
            return 0;
        }
        if (m == row - 1 && n == col -1) { 
            return 1;
        }

        String key = m + "," + n;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int result = recursion(obstacleGrid,m+1,n) + recursion(obstacleGrid,m,n+1);

        map.put(key, result);

        return result;
    }
}
