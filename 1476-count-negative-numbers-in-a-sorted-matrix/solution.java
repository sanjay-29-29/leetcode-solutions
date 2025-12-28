class Solution {
    public int countNegatives(int[][] grid) {
        int res = grid.length * grid[0].length;
        outer: for(int i[] : grid) {
            for(int j : i) {
                if(j >= 0) {
                    res--;
                }
            }
        }
        return res;
    }
}
