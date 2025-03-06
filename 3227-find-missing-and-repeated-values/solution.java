class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        
        Set<Integer> set = new HashSet<>();
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(set.contains(grid[i][j])){
                    res[0] = grid[i][j]; 
                }else{ 
                    count += grid[i][j];
                    set.add(grid[i][j]);
                }
            }
        }
        int n = grid.length * grid[0].length;
        int sum = (n * (n + 1)) / 2;
        //System.out.println(sum + " " + count);
        res[1] = sum - count;
        return res;
    }
}
