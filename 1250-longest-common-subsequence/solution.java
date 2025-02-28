class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];

        for(int i = 0; i < text1.length(); i++){
            Arrays.fill(dp[i], -1);
        }

        return recursion(text1, text2, 0, 0, dp);
    }

    private int recursion(String text1, String text2, int i1, int i2, int[][] dp){
        if(i1 >= text1.length() || i2 >= text2.length()){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }

        if(text1.charAt(i1) == text2.charAt(i2)){
            dp[i1][i2] = Math.max(1 + recursion(text1, text2, i1 + 1, i2 + 1, dp), Math.max(
                recursion(text1, text2, i1, i2 + 1, dp),
                recursion(text1, text2, i1 + 1, i2, dp)
            ));
            return dp[i1][i2];
        }

        dp[i1][i2] = Math.max(recursion(text1, text2, i1, i2 + 1, dp),
                recursion(text1, text2, i1 + 1, i2, dp));
        return dp[i1][i2];
    }
}
