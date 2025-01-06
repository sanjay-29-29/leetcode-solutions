class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int count = 0;
        int row = 0;
        int col = 0;

        while (count != (matrix[0].length * matrix.length)) {
            while (col < matrix[0].length && !set.contains(row + " " + col)) {
                res.add(matrix[row][col]);
                set.add(row + " " + col);
                // System.out.println(row + " " + col);
                count++;
                col++;
            }
            col--;
            row++;

            while (row < matrix.length && !set.contains(row + " " + col)) {
                res.add(matrix[row][col]);
                set.add(row + " " + col);
                // System.out.println(row + " " + col);
                count++;
                row++;
            }
            row--;
            col--;

            while (col >= 0 && !set.contains(row + " " + col)) {
                res.add(matrix[row][col]);
                set.add(row + " " + col);
                // System.out.println(row + " " + col);
                count++;
                col--;
            }
            col++;
            row--;

            while (row >= 0 && !set.contains(row + " " + col)) {
                res.add(matrix[row][col]);
                set.add(row + " " + col);
                // System.out.println(row + " " + col);
                count++;
                row--;
            }
            col++;
            row++;
        }

        return res;
    }
}
