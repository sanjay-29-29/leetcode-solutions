class Solution {
    int row;
    int col;
    
    public int minPathSum(int[][] grid) {
        HashMap<String, Integer> map = new HashMap<>();
        row = grid.length;
        col = grid[0].length;
        
        return minPathSumFunc(grid,0,0,map);
    }

    private int minPathSumFunc(int[][] grid, int n, int m, HashMap<String,Integer> map){
        String key = m + "," + n;

        if(map.containsKey(key)){
            return map.get(key);
        }

        if(n >= row || m >= col){
            return Integer.MAX_VALUE;
        }
        
        if(n == row-1 && m == col-1){
            return grid[n][m];
        }
        
        int val = grid[n][m] + Math.min(minPathSumFunc(grid, n + 1, m, map), minPathSumFunc(grid, n, m + 1, map));
        map.put(key,val);
        return val;
    }
}
