class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[matrix.length - 1][i] = matrix[matrix.length - 1][i];
        }

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    // System.out.println(i + " " + j);
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j + 1], dp[i + 1][j]);
                } else if (j == matrix[0].length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j - 1], dp[i + 1][j]);
                } else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i + 1][j + 1], Math.min(
                            dp[i + 1][j], dp[i + 1][j - 1]));
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(dp[0][i], res);
        }
        return res;
    }

    // private int recurse(int[][] matrix, int i, int j) {
    //     if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
    //         return 99999;
    //     }
    //     if (i == matrix.length - 1) {
    //         return matrix[i][j];
    //     }
    //     if (dp[i][j] != -1) {
    //         return dp[i][j];
    //     }
    //     int val = matrix[i][j] + Math.min(
    //             recurse(matrix, i + 1, j),
    //             Math.min(
    //                     recurse(matrix, i + 1, j - 1),
    //                     recurse(matrix, i + 1, j + 1)));
    //     dp[i][j] = val;
    //     return val;
    // }
}
