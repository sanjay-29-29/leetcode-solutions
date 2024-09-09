class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(m*n != original.length){
            return new int[0][0];
        }

        int[][] matrix = new int[m][n];
        
        int row = 0;
        int col = 0;

        for(int i=0;i<original.length;i++){
            if(row>m-1 || col>n-1){
                row++;
                col = 0;
            }
            matrix[row][col++] = original[i];
        }
        return matrix;
    }
}
