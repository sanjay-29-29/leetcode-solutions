class Solution {
    public int minimumArea(int[][] grid) {
        int minX = Integer.MAX_VALUE, 
        minY = Integer.MAX_VALUE, 
        maxX = Integer.MIN_VALUE, 
        maxY = Integer.MIN_VALUE;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    minX = Math.min(i, minX);
                    maxX = Math.max(i, maxX);
                    minY = Math.min(j, minY);
                    maxY = Math.max(j, maxY);
                }
            }
        }

        return (maxX - minX + 1) * (maxY - minY + 1);        
    }
}
