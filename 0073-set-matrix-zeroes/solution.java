class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();

        List<int[]> list = new LinkedList<>();

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        for(int[] i : list) {
            setZero(matrix, i[0], i[1], rowSet, colSet);
        }

    }

    private void setZero(int[][] matrix, int row, int col, Set<Integer> rowSet, Set<Integer> colSet) {
        if(!colSet.contains(col)) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
            colSet.add(col);
        }
        if(!rowSet.contains(row)) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
            rowSet.add(row);
        }
    }
}
