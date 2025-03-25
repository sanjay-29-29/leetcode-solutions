class Solution {
    int[] dp;
    public int minCut(String s) {
        dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return recursion(s, 0);
    }

    private int recursion(String s, int index) {
        if (index >= s.length()) {
            return 0;
        }
        if (isPalindrome(s, index, s.length() - 1)) {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int min = Integer.MAX_VALUE;
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                // System.out.println(ss);
                min = Math.min(min, 1 + recursion(s, i + 1));
            }
        }
        dp[index] = min;
        return min;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
