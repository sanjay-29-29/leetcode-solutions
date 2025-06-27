class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < matrix[0].length; k++) {
                    if (k == j)
                        continue;
                    min = Math.min(min, dp[i + 1][k]);
                }
                dp[i][j] = min + matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(dp[0][i], res);
        }

        return res;
    }
}
