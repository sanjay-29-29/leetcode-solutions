class Solution {
    int[][][] dp;

    class Count {
        int zero, one;

        Count(int z, int o) {
            zero = z;
            one = o;
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        Count[] arr = new Count[strs.length];
        this.dp = new int[strs.length + 1][m + 1][n + 1];

        for(int[][] i : dp)  {
            for(int[] j : i) {
                Arrays.fill(j, -1);
            }
        }

        for (int i = 0; i < strs.length; i++) {
            arr[i] = getCount(strs[i]);
        }

        return recurse(arr, m, n, 0);
    }

    private int recurse(Count[] arr, int m, int n, int i) {
        if (i >= arr.length)
            return 0;

        if (m == 0 && n == 0)
            return 0;


        if(dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        int val = 0;

        if (m - arr[i].zero >= 0 && n - arr[i].one >= 0) {
            val = Math.max(
                    recurse(arr, m, n, i + 1),
                    1 + recurse(arr, m - arr[i].zero, n - arr[i].one, i + 1));
        } else {
            val = recurse(arr, m, n, i + 1);
        }
        dp[i][m][n] = val;
        return val;
    }

    private Count getCount(String s) {
        int one = 0, zero = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zero++;
            else
                one++;
        }
        return new Count(zero, one);
    }
}
