class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int negativeCount = 0;
        int min = Integer.MAX_VALUE;
        boolean containsZero = false;
        long sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < 0) {
                    negativeCount++;
                }

                if (matrix[i][j] == 0)
                    containsZero = true;

                sum += Math.abs(matrix[i][j]);

                min = Math.min(Math.abs(matrix[i][j]), min);
            }
        }

        if (negativeCount % 2 == 0 || containsZero) {
            return sum;
        }
        System.out.println(sum);
        return sum - (min * 2);

    }
}
