class Solution {
    public int minOperations(int[][] grid, int x) {
        int[] res = new int[grid.length * grid[0].length];
        int k = 0;
        
        if(res.length == 1){
            return 0;
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                res[k++] = grid[i][j];
            }
        }

        
        Arrays.sort(res);
        int median = res[res.length / 2], count = 0;

        for(int i =0; i < res.length; i++){
            int diff = Math.abs(res[i] - median);
            if(diff % x != 0){
                return -1;
            }
            count += diff / x;
        }

        return count;
    }
}
