class Solution {
    int maxArea;
    HashSet<String> set;

    public int maxAreaOfIsland(int[][] grid) {
        set = new HashSet<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, traverseGrid(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int traverseGrid(int grid[][], int i, int j){
        boolean exp1 = (0 <= i && i < grid.length);
        boolean exp2 = (0 <= j && j < grid[0].length);
        if(!exp1 || !exp2) return 0;
        if(grid[i][j] == 0){
            return 0;
        }
        
        String pos = i + "," + j;
        if(set.contains(pos)){
            return 0;
        }
        set.add(pos);

        int currArea = 1;
        currArea += traverseGrid(grid, i+1, j);
        currArea += traverseGrid(grid, i-1, j); 
        currArea += traverseGrid(grid, i, j+1); 
        currArea += traverseGrid(grid, i, j-1);

        return currArea;
    }
}
