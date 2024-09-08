class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                boolean isEqual = true;
                for(int k=0;k<grid.length;k++){
                    if(grid[i][k] != grid[k][j]){
                        isEqual = false;
                        break;
                    }
                }
                if(isEqual){
                    count++;
                }
                isEqual = true;
            }
        }
        return count;
    }
}
