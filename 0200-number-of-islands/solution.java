class Solution {
    HashSet<String> set;
    public int numIslands(char[][] grid) {
        set = new HashSet<>();
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(traverse(grid, i, j) == true){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean traverse(char[][] grid, int i, int j){
        boolean exp1 = (0 <= i && i<grid.length);
        boolean exp2 = (0 <= j && j<grid[0].length);
        if(!exp1 || !exp2) return false;

        String pos = i + "," + j;

        if(set.contains(pos)){
            return false;
        };

        if(grid[i][j] == '0'){
            return false;
        }

        set.add(pos);
        
        traverse(grid, i + 1 , j);
        traverse(grid, i , j + 1);
        traverse(grid, i - 1, j);
        traverse(grid, i , j - 1);
        
        System.out.println(pos);
        return true;
    }
}
